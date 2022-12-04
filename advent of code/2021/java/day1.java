/**
 * Advent of Code 2021 - Day 1: Sonar Sweep
 * 30 November 2021
 * 11:01 PM - 11:20 PM
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        part1(); // 13 minutes
        part2(); // 6 minutes
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day1.txt");

        Scanner sc = new Scanner(input);
        ArrayList<Integer> measurements = new ArrayList<>();

        while(sc.hasNextLine()) {
            measurements.add(sc.nextInt());
        }

        //
        //System.out.println(measurements.size());

        int counter = 0;
        int index = 0;

        for(int measurement : measurements) {
            if(index == 0) { // onlny happens at the beginning
                index++;
            } else {
                if(measurement > measurements.get(index-1)) { // w/o index-1, comparing measurement to itself
                    counter++;
                }
                index++;
            }
        }

        sc.close();

        System.out.println(counter);
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day1.txt");

        Scanner sc = new Scanner(input);
        ArrayList<Integer> measurements = new ArrayList<>();

        while(sc.hasNextLine()) {
            measurements.add(sc.nextInt());
        }

        ArrayList<Integer> sums = new ArrayList<>();

        // getting all the sums
        for(int i = 0; i < measurements.size() - 2; i++) {
            sums.add(measurements.get(i) + measurements.get(i+1) + measurements.get(i+2));
        }

        //System.out.println(sums.size());

        int counter = 0;
        int index = 0;

        for(int sum : sums) {
            if(index == 0) { // onlny happens at the beginning
                index++;
            } else {
                if(sum > sums.get(index-1)) { // w/o index-1, comparing measurement to itself
                    counter++;
                }
                index++;
            }
        }

        sc.close();

        System.out.println(counter);
    }
}