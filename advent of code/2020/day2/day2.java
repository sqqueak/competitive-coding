// Password Philosophy

package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String args[]) {
        part2();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day2\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<String[]> components = new ArrayList<>();

        for(String str : inputs) { // parsing data into usable parts
            String[] reqsAndPass = str.split(": ");
            final String PASSWORD = reqsAndPass[1];

            String[] numsAndChar = reqsAndPass[0].split(" ");
            final String CHARACTER = numsAndChar[1];

            String[] minAndMax = numsAndChar[0].split("-");
            final String MIN = minAndMax[0];
            final String MAX = minAndMax[1];

            components.add(new String[] { MIN, MAX, CHARACTER, PASSWORD });
        }

        ArrayList<String> validPasswords = new ArrayList<>();

        for(String[] sections : components) {
            if(sections[3].matches(
                "^(?:[^" + sections[2] + "]*[" + sections[2] + "]){" + 
                sections[0] + "," + sections[1] + "}[^" + sections[2] + "]*$"
            )) validPasswords.add(sections[3]); 
        }

        System.out.println(validPasswords.size());
    }

    public static void part2() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day2\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<String[]> components = new ArrayList<>();

        for(String str : inputs) { // parsing data into usable parts
            String[] reqsAndPass = str.split(": ");
            final String PASSWORD = reqsAndPass[1];

            String[] numsAndChar = reqsAndPass[0].split(" ");
            final String CHARACTER = numsAndChar[1];

            String[] minAndMax = numsAndChar[0].split("-");
            final String INDEX1 = minAndMax[0];
            final String INDEX2 = minAndMax[1];

            components.add(new String[] { INDEX1, INDEX2, CHARACTER, PASSWORD });
        }

        ArrayList<String> validPasswords = new ArrayList<>();

        for(String[] sections : components) {
            int index1 = Integer.parseInt(sections[0]) - 1;
            int index2 = Integer.parseInt(sections[1]) - 1;
            String character = sections[2];
            String password = sections[3];

            if(password.substring(index1, index1 + 1).equals(character) ^
            password.substring(index2, index2 + 1).equals(character)) {
                validPasswords.add(password);
            }
        }

        System.out.println(validPasswords.size());
    }
}
