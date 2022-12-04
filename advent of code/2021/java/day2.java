/**
 * Advent of Code 2021 - Day 2: Dive!
 * 1 December 2021
 * 11:00 PM - 11:10 PM
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        part1(); // 6 minutes
        part2(); // 4 minutes
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day2.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> movements = new ArrayList<>();

        while(sc.hasNextLine()) {
            movements.add(sc.nextLine());
        }

        ArrayList<String[]> parsedMovements = new ArrayList<>();

        for(String movement : movements) {
            parsedMovements.add(movement.split(" "));
        }

        int depth =0;
        int horizontal =0;

        System.out.println(parsedMovements.get(0)[0] + parsedMovements.get(0)[1]);

        for(String[] parsed : parsedMovements) {
            if(parsed[0].contains("forward")) {
                horizontal += Integer.parseInt(parsed[1]);
            } else if(parsed[0].contains("down")) {
                depth += Integer.parseInt(parsed[1]);
            } else if(parsed[0].contains("up")) {
                depth -= Integer.parseInt(parsed[1]);
            }
        }

        System.out.println(depth*horizontal);

        sc.close();
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day2.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> movements = new ArrayList<>();

        while(sc.hasNextLine()) {
            movements.add(sc.nextLine());
        }

        ArrayList<String[]> parsedMovements = new ArrayList<>();

        for(String movement : movements) {
            parsedMovements.add(movement.split(" "));
        }

        int depth =0;
        int horizontal =0;
        int aim=0;

        for(String[] parsed : parsedMovements) {
            if(parsed[0].contains("forward")) {
                horizontal += Integer.parseInt(parsed[1]);
                depth += aim*Integer.parseInt(parsed[1]);
            } else if(parsed[0].contains("down")) {
                aim += Integer.parseInt(parsed[1]);
            } else if(parsed[0].contains("up")) {
                aim -= Integer.parseInt(parsed[1]);
            }
        }

        System.out.println(horizontal*depth);

        sc.close();
    }
}