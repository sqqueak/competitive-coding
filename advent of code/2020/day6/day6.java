// Custom Customs

package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {
    public static void main(String args[]) {
        part2();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day6\\input.txt");
        try {
            Scanner scanner = new Scanner(input);
            String group = "";

            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();

                if(currLine.isBlank()) {
                    inputs.add(group);
                    group = "";
                } else {
                    group += (currLine + " ");
                }
            }
    
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        int count = 0;

        for(String group : inputs) {
            boolean[] questionStatus = new boolean[26];
            String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
                                 "i", "j", "k", "l", "m", "n", "o", "p",
                                 "q", "r", "s", "t", "u", "v", "w", "x",
                                 "y", "z"};

            for(int i = 0; i < 26; i++) {
                if(group.contains(alphabet[i])) {
                    questionStatus[i] = true;
                }
            }

            for(boolean question : questionStatus) {
                if(question == true) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
    
    public static void part2() {
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<Integer> numOfPeople = new ArrayList<>();

        File input = new File("day6\\input.txt");
        try {
            Scanner scanner = new Scanner(input);
            String group = "";
            int people = 0;

            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();

                if(currLine.isBlank()) {
                    answers.add(group);
                    numOfPeople.add(people);
                    group = "";
                    people = 0;
                } else {
                    group += (currLine + " ");
                    people++;
                }
            }
    
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        int count = 0;
        int counterForNumOfPeople = 0;

        for(String group : answers) {
            boolean[] questionStatus = new boolean[26];
            String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
                                 "i", "j", "k", "l", "m", "n", "o", "p",
                                 "q", "r", "s", "t", "u", "v", "w", "x",
                                 "y", "z"};

            for(int i = 0; i < 26; i++) {
                if(group.contains(alphabet[i])) {
                     
                    String regex = ".*";
                    for(int j = 0; j < numOfPeople.get(counterForNumOfPeople); j++) {
                        regex += alphabet[i] + ".*";
                    }

                    if(group.matches(regex)) {
                        questionStatus[i] = true;
                    }
                }
            }

            for(boolean question : questionStatus) {
                if(question == true) {
                    count++;
                }
            }

            counterForNumOfPeople++;
        }

        System.out.println(count);
    }
}