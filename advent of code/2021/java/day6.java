/**
 * Advent of Code 2021 - Day 6: Lanternfish
 * 5 December 2021 - 6 December 2021
 * 
 * part 1: 20 minutes
 * part 2: 43 minutes (with some downtime)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day6.txt");

        Scanner sc = new Scanner(input);
        String[] inputs = sc.nextLine().split(",");

        ArrayList<Integer> fishTimer = new ArrayList<>();

        for(String in : inputs) {
            fishTimer.add(Integer.parseInt(in));
        }

        sc.close();

        for(int i = 0; i < 80; i++) {
            ArrayList<Integer> currFishes = fishTimer;

            for(int j = 0; j < currFishes.size(); j++) {
                int currFish = fishTimer.get(j);

                fishTimer.set(j, currFish-1);

                if(currFish == 0) {
                    fishTimer.add(9);
                    fishTimer.set(j, 6);
                }
            }
            System.out.println(i);

            //System.out.println(fishTimer);
        }

        System.out.println(fishTimer.size());
    }

    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("inputs/day6.txt");

        Scanner sc = new Scanner(input);
        String[] inputs = sc.nextLine().split(",");

        ArrayList<Integer> fishTimer = new ArrayList<>();

        for(String in : inputs) {
            fishTimer.add(Integer.parseInt(in));
        }

        sc.close();

        // for(int fish : fishTimer) {
        //     System.out.println(fish);
        // }

        BigInteger[] fishes = {BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),
            BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0) };

        for(int fish : fishTimer) {
            fishes[fish] = fishes[fish].add(BigInteger.valueOf(1));
        }

        for(BigInteger fish : fishes) {
            System.out.print(fish);
            System.out.print(" ");
        }
        System.out.println();
                                           //0,1,0,5,6,7,8
        for(int day = 0; day < 256; day++) { //6,0,6,4,5,6,7,8,8 

            BigInteger zeroFishes = fishes[0];

            BigInteger[] copy = fishes;

            for(int i = 0; i < 8; i++) {
                fishes[i] = copy[i+1]; // moving all fishes down one
            }
            fishes[8] = BigInteger.valueOf(0);

            fishes[6] = fishes[6].add(zeroFishes); // adding back fish
            fishes[8] = fishes[8].add(zeroFishes);

            for(BigInteger fish : fishes) {
                System.out.print(fish);
                System.out.print(" ");
            }
            System.out.println();
        }

        BigInteger finVal = BigInteger.valueOf(0);
        for(BigInteger fish : fishes) {
            finVal = finVal.add(fish);
        }

        System.out.println(finVal);
    }
}