// Handheld Halting

package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day8 {
    public static void main(String args[]) {
        //part1();
        part2();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day8\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        int accumulator = 0;
        int lineCounter = 0;
        ArrayList<String[]> instructions = new ArrayList<>();
        ArrayList<Boolean> isVisited = new ArrayList<>();

        for(String line : inputs) {
            instructions.add(line.split(" "));
            isVisited.add(false);
        }

        while(isVisited.get(lineCounter) == false) {
            String instruction = instructions.get(lineCounter)[0];
            String argument = instructions.get(lineCounter)[1];

            if(instruction.contains("acc")) {
                isVisited.set(lineCounter, true);
                if(argument.contains("+")) {
                    accumulator += Integer.parseInt(argument.split("\\+")[1]);
                } else if(argument.contains("-")) {
                    accumulator -= Integer.parseInt(argument.split("-")[1]);
                }
                lineCounter++;
            } else if(instruction.contains("jmp")) {
                isVisited.set(lineCounter, true);
                if(argument.contains("+")) {
                    lineCounter += Integer.parseInt(argument.split("\\+")[1]);
                } else if(argument.contains("-")) {
                    lineCounter -= Integer.parseInt(argument.split("-")[1]);
                }
            } else {
                lineCounter++;
            }
        }

        System.out.println(accumulator);
    }

    public static void part2() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day8\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        int accumulator = 0;
        int lineCounter = 0;
        ArrayList<String[]> instructions = new ArrayList<>();
        ArrayList<Boolean> isVisited = new ArrayList<>();

        for(String line : inputs) {
            instructions.add(line.split(" "));
            isVisited.add(false);
        }

        while(lineCounter != 642) {
            accumulator = 0;
            lineCounter = 0;
            
        }
    }

}