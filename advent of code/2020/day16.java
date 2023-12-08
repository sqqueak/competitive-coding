/**
 * 10-15 November 2021, don't remember exactly :(
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day16 {
    public static void main(String[] args) {
        part1();
    }

    public static void part1() {
        ArrayList<String> inputRules = new ArrayList<>();
        //String myTicket = "";
        ArrayList<String> inputOtherTickets = new ArrayList<>();

        File input = new File("day16//input.txt");
        try {
            Scanner scanner = new Scanner(input);
            String currLine = scanner.nextLine();

            // prints out rules without gaps
            while(!currLine.isBlank()) {
                inputRules.add(currLine);
                currLine = scanner.nextLine();
            }

            // first break in text - filtering out "your ticket:" and showing my ticket numbers
            scanner.nextLine();
            scanner.nextLine(); // THIS LINE WOULD BE MY TICKET NUMBERS

            // second break in text - filtering out "nearby tickets:"
            scanner.nextLine();
            scanner.nextLine();

            while(scanner.hasNextLine()) {
                currLine = scanner.nextLine();
                inputOtherTickets.add(currLine);
            }
           
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        // parsing the rules
        String[][] rulesTemp = new String[inputRules.size()][4];

        // iterating through every rule to find boundaries
        for(int i = 0; i < rulesTemp.length; i++) {
            String[] firstParse = inputRules.get(i).split(":");
            String[] secondParse = firstParse[1].split("or");
            rulesTemp[i][0] = secondParse[0].strip().split("-")[0];
            rulesTemp[i][1] = secondParse[0].strip().split("-")[1];
            rulesTemp[i][2] = secondParse[1].strip().split("-")[0];
            rulesTemp[i][3] = secondParse[1].strip().split("-")[1];
            // System.out.println(rulesTemp[i][0] + " " + rulesTemp[i][1] + " " + rulesTemp[i][2] + " " + rulesTemp[i][3]);
        }

        int[][] parsedRules = new int[rulesTemp.length][rulesTemp[0].length];
        
        for(int i = 0; i < rulesTemp.length; i++) {
            for(int ii = 0; ii < rulesTemp[0].length; ii++) {
                parsedRules[i][ii] = Integer.parseInt(rulesTemp[i][ii]);
            }
        }


        // setup because i don't want to hardcode the number of data in the ticket
        String[] setupForGettingArraySize = inputOtherTickets.get(0).split(",");
        int sizeOfTicket = setupForGettingArraySize.length;

        // parsing through other tickets
        int[][] parsedTickets = new int[inputOtherTickets.size()][sizeOfTicket];

        for(int i = 0; i < parsedTickets.length; i++) {
            String[] stringTickets = inputOtherTickets.get(i).split(",");
            for(int ii = 0; ii < stringTickets.length; ii++) {
                parsedTickets[i][ii] = Integer.parseInt(stringTickets[ii]);
            }
        }

        /**
         * parsedTickets is a 2D array of all the ticket values, each row representing one ticket
         * rulesTemp // TODO change name of array but i can't fucking figure out how to refactor it
         */

        // // debugging method, printing out the entire array
        // for(int i = 0; i < parsedTickets.length; i++) {
        //     for(int ii = 0; ii < parsedTickets[0].length; ii++) {
        //         System.out.print("[" + parsedTickets[i][ii] + "] ");
        //     }
        //     System.out.println();
        // }

        int cumErrors = 0;

        // testing if each number of each ticket is between all of the rules
        // this is going to be really slow since it's iterating through THREE different loops? so O^3 but its constant?
        for(int i = 0; i < parsedTickets.length; i++) {

            for(int ii = 0; ii < parsedTickets[0].length; ii++) {
                boolean isCurrValValid = false;

                // iterating through each CELL
                int currVal = parsedTickets[i][ii];

                for(int j = 0; j < parsedRules.length; j++) {
                    if((currVal > parsedRules[j][0] && currVal < parsedRules[j][1]) ||
                                (currVal > parsedRules[j][2] && currVal < parsedRules[j][3])) {
                        isCurrValValid = true;
                        break;
                    }
                }

                if(isCurrValValid == false) {
                    cumErrors += currVal;
                }
            }
        }

        System.out.println(cumErrors);
    }
}
