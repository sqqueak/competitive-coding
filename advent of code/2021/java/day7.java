/**
 * Advent of Code 2021 - Day 7: The Treachery of Whales
 * 6 December 2021
 * 
 * part 1: 
 * part 2: 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day7 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day7.txt");

        Scanner sc = new Scanner(input);
        String[] inputs = sc.nextLine().split(",");

        ArrayList<Integer> crabPosition = new ArrayList<>();

            for(String in : inputs) {
            crabPosition.add(Integer.parseInt(in));
        }

        double ave = 0;

        for(int i = 0; i < crabPosition.size(); i++) {
            ave += crabPosition.get(i);
        }

        int average = Math.round((float)ave /crabPosition.size());

        System.out.println(average);

        // finding 20% around the average

        int lowerBound = (int) Math.round((float)average * 0.3);
        int upperBound = (int) Math.round((float)average * 0.2) + average;

        System.out.println(lowerBound + " " + upperBound);

        double leastFuel = Double.POSITIVE_INFINITY;

        for(int i = lowerBound; i < upperBound; i++) {
            int currFuel = 0;
            
            for(int crab : crabPosition) {
                currFuel += Math.abs(crab - i);
            }

            if(currFuel < leastFuel) leastFuel = currFuel;
        }

        System.out.println(leastFuel);

        sc.close();
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day7.txt");

        Scanner sc = new Scanner(input);
        String[] inputs = sc.nextLine().split(",");

        ArrayList<Integer> crabPosition = new ArrayList<>();

        for(String in : inputs) {
            crabPosition.add(Integer.parseInt(in));
        }

        double ave = 0;

        for(int i = 0; i < crabPosition.size(); i++) {
            ave += crabPosition.get(i);
        }

        int average = Math.round((float)ave /crabPosition.size());

        System.out.println(average);

        // finding 20% around the average

        int lowerBound = (int) Math.round((float)average * 0.3);
        int upperBound = (int) Math.round((float)average * 0.2) + average;

        System.out.println(lowerBound + " " + upperBound);

        long leastFuel = 100000000;

        for(int i = lowerBound; i < upperBound; i++) {
            int currFuel = 0;
            
            for(int crab : crabPosition) {

                for(int step = 1; step <= Math.abs(crab - i); step++) {
                    currFuel += step;
                }
            }

            if(currFuel < leastFuel) leastFuel = currFuel;
        }

        System.out.println(leastFuel);

        sc.close();
    }
}