// Encoding Error

package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day9 {
    public static void main(String args[]) {
        part1();
        part2();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day9\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        long[] longInputs = new long[inputs.size()];
        
        // changing the inputs to integer type
        int counter = 0;
        for(String str : inputs ) {
            longInputs[counter] = Long.parseLong(str);
            counter++;
        }

        // accounts for previous 25 numbers
        long[] prev25 = new long[25];

        for(int i = 25; i < longInputs.length; i++) {
            getPrevious25(i, longInputs, prev25);
            long current = longInputs[i];
            boolean hasProperty = false;
            
            for(int l1 = 0; l1 < 25; l1++) {
                for(int l2 = l1; l2 < 25; l2++) {
                    if(prev25[l1] + prev25[l2] == current && prev25[l1] != prev25[l2]) {
                        hasProperty = true;
                    }
                }
            }

            if(!hasProperty) {
                System.out.println(current);
            }
        }
    }

    public static void part2() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day9\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        long[] longInputs = new long[inputs.size()];
        
        // changing the inputs to integer type
        int counter = 0;
        for(String str : inputs ) {
            longInputs[counter] = Long.parseLong(str);
            counter++;
        }

        // accounts for previous 25 numbers
        long[] prev25 = new long[25];
        long val = 0;

        for(int i = 25; i < longInputs.length; i++) {
            getPrevious25(i, longInputs, prev25);
            long current = longInputs[i];
            boolean hasProperty = false;
            
            for(int l1 = 0; l1 < 25; l1++) {
                for(int l2 = l1; l2 < 25; l2++) {
                    if(prev25[l1] + prev25[l2] == current && prev25[l1] != prev25[l2]) {
                        hasProperty = true;
                    }
                }
            }
        
            if(!hasProperty) {
                val = current;
                break;
            }
        }
        
        ////////////////////////// NEW CODE //////////////////////////

        long[] valOptions = new long[longInputs.length];
        int index = 0;

        for(int i = 0; longInputs[i] != val; i++) {
            long sum = longInputs[i];
            int iCounter = i;
            while(sum < val) {
                iCounter++;
                sum += longInputs[iCounter];
                if(sum > val) {
                    break;
                }
                if(sum == val) {
                    index = i;
                    //System.out.println(sum);
                    break;
                }
            }
            if(sum == val) {
                break;
            }
        }

        int iCounter = index;
        int indexCounter = 1;
        long sum = longInputs[index];
        valOptions[0] = longInputs[index];

        while(sum < val) {
            iCounter++;
            sum += longInputs[iCounter];
            valOptions[indexCounter] = longInputs[iCounter];
            indexCounter++;
            //System.out.println(sum);
        }
        
        // finding biggest and smallest
        long biggest = 0;
        long smallest = (long) Double.POSITIVE_INFINITY;
        for(int i = 0; i < valOptions.length; i++) {
            if(valOptions[i] > biggest) {
                biggest = valOptions[i];
            } 
            if(valOptions[i] < smallest && valOptions[i] != (long) 0) {
                smallest = valOptions[i];
            }
        }

        System.out.println(biggest+smallest);
    }

    /**
     * gets the value of the index and the 24 numbers before it
     * @param index
     * @param input
     * @param previous
     */
    public static void getPrevious25(int index, long[] input, long[] previous) {
        int goal = index+25;
        int counter = 0;
        // System.out.println(index + " " + goal);
        for(int i = index; i < goal; i++) {
            previous[counter] = input[i-25];
            counter++;
        }
    }
}
