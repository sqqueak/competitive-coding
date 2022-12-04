// Report Repair

package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    public static void main(String args[]) {
        part1();
        part2();
    }

    public static void part1() {
        ArrayList<Integer> numbers = new ArrayList<>();

        File input = new File("day1\\input.txt"); // reading file input
        try {
            Scanner scanner = new Scanner(input);

            while(scanner.hasNextLine()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<Integer[]> answer = new ArrayList<>();

        for(int i = 0; i < numbers.size() - 1; i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(i) + numbers.get(j) == 2020) {

                    Integer[] permutation = { 
                        numbers.get(i), 
                        numbers.get(j), 
                        numbers.get(i) * numbers.get(j)
                    };

                    answer.add(permutation);
                }
            }
        }

        System.out.println(answer.get(0)[2]);
    }

    public static void part2() {
        ArrayList<Integer> numbers = new ArrayList<>();

        File input = new File("day1\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while(scanner.hasNextLine()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<Integer[]> answer = new ArrayList<>();

        for(int i = 0; i < numbers.size() - 2; i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                for(int k = i + 2; k < numbers.size(); k++) {
                    if(numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {

                        Integer[] permutation = { 
                            numbers.get(i), 
                            numbers.get(j), 
                            numbers.get(k),
                            numbers.get(i) * numbers.get(j) * numbers.get(k)
                        };
    
                        answer.add(permutation);
                    }
                }
            }
        }

        System.out.println(answer.get(0)[3]);
    }
}