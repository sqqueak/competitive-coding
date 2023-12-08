/**
 * 18 November 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class day22 {

    public static void main(String[] args) {
        part1();
    }

    public static void part1() {
        File input = new File("day22//input.txt");
        LinkedList<Integer> player1 = new LinkedList<>();
        LinkedList<Integer> player2 = new LinkedList<>();

        try {
            Scanner scanner = new Scanner(input);

            // parsing player 1
            scanner.nextLine();
            String currLine = scanner.nextLine();

            while(!currLine.isBlank()) {
                player1.add(Integer.parseInt(currLine));
                System.out.println(currLine);
                currLine = scanner.nextLine();
            }

            scanner.nextLine();

            // parsing player 2
            while(scanner.hasNextLine()) {
                currLine = scanner.nextLine();
                player2.add(Integer.parseInt(currLine));
                System.out.println(currLine);
            }
           
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        while(!player1.isEmpty() && !player2.isEmpty()) {
            if(player1.peek() > player2.peek()) {
                player1.add(player1.pop());
                player1.add(player2.pop());
            } else {
                player2.add(player2.pop());
                player2.add(player1.pop());
            }
        }

        // hardcoding player 1's winning list because i'm lazy 
        int score = 0;
        for(int i = 50; i > 0; i--) {
            score += i*player1.pop();
        }

        System.out.println(score);
    }
}