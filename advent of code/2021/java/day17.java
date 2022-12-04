/**
 * Advent of Code 2021 - Day 17: Transparent Origami
 * 15 December 2021
 * 
 * part 1: 100 minutes
 * part 2: 8 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day17 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        //part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day17.txt");

        Scanner sc = new Scanner(input);
        String[] split1 = sc.nextLine().split(" ");
        
        ArrayList<String[]> instructions = new ArrayList<>();
        String currLine = sc.nextLine();

        // int startingX = 0;
        // int startingY = 59;
        // char[][] chart = new char[60][31];

        // for(int i = 11; i <= 16 ; i++) {
        //     for(int j = 20; j <= 30; j++) {
        //         chart[i][j] = 'T';
        //     }
        // }

        // chart[startingY][startingX] = 'S';
        // int velX = 6;
        // int velY = 9;

        // for(int i = 0; i < 8; i++) {
        //     startingX += velX;
        //     startingY -= velY;

        //     chart[startingY][startingX] = '#';

        //     if(velX > 0) {
        //         velX--;
        //     } else if(velX < 0) {
        //         velX++;
        //     }

        //     velY--;
        // }

        // for(int i = 0; i < 60; i++) {
        //     for(int j = 0; j < 31; j++) {
        //         if(chart[i][j] == 0) System.out.print(".");
        //         else System.out.print(chart[i][j]);
        //     }
        //     System.out.println();
        // }

    }
}