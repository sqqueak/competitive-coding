/**
 * Advent of Code 2021 - Day 11: Dumbo Octopus
 * 11 December 2021
 * 
 * part 1: 30 ish minutes?
 * part 2: 8 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class day11 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day11.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }
        sc.close();

        List<char[]> filtered = Stream.of(inputs.toArray(new String[0]))
            .map(i -> i.toCharArray())
            .toList();

        int[][] field = new int[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                field[i][j] = Character.getNumericValue(filtered.get(i)[j]);
            }
        }

        int flash = 0;

        for(int i = 0; i < 100; i++) {
            boolean isFlashesLeft = false;

            for(int k = 0; k < 10; k++) {
                for(int j = 0; j < 10; j++) {
                    field[k][j]++;
                }
            }

            while(!isFlashesLeft) {
                isFlashesLeft = true;
                
                for(int k = 0; k < 10; k++) {
                    for(int j = 0; j < 10; j++) {
                        
                        if(field[k][j] > 9) {
                            isFlashesLeft = false;
                            field[k][j] = 0;
                            flash++;

                            if(isValid(field, k-1, j-1)) { // top left
                                field[k-1][j-1]++;
                            }
                            if(isValid(field, k-1, j)) { // top mid
                                field[k-1][j]++;
                            }
                            if(isValid(field, k-1, j+1)) { // top right
                                field[k-1][j+1]++;
                            }
                            if(isValid(field, k, j-1)) { // mid left
                                field[k][j-1]++;
                            }
                            if(isValid(field, k, j+1)) { // mid right
                                field[k][j+1]++;
                            }
                            if(isValid(field, k+1, j-1)) { // bot left
                                field[k+1][j-1]++;
                            }
                            if(isValid(field, k+1, j)) { // bot mid
                                field[k+1][j]++;
                            }
                            if(isValid(field, k+1, j+1)) { // bot right
                                field[k+1][j+1]++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(flash);
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day11.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }
        sc.close();

        List<char[]> filtered = Stream.of(inputs.toArray(new String[0]))
            .map(i -> i.toCharArray())
            .toList();

        int[][] field = new int[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                field[i][j] = Character.getNumericValue(filtered.get(i)[j]);
            }
        }

        boolean isAllFlashed = true;

        for(int i = 0; isAllFlashed; i++) {
            boolean isFlashesLeft = false;

            for(int k = 0; k < 10; k++) {
                for(int j = 0; j < 10; j++) {
                    field[k][j]++;
                }
            }

            while(!isFlashesLeft) {
                isFlashesLeft = true;
                
                for(int k = 0; k < 10; k++) {
                    for(int j = 0; j < 10; j++) {
                        
                        if(field[k][j] > 9) {
                            isFlashesLeft = false;
                            field[k][j] = 0;

                            if(isValid(field, k-1, j-1)) { // top left
                                field[k-1][j-1]++;
                            }
                            if(isValid(field, k-1, j)) { // top mid
                                field[k-1][j]++;
                            }
                            if(isValid(field, k-1, j+1)) { // top right
                                field[k-1][j+1]++;
                            }
                            if(isValid(field, k, j-1)) { // mid left
                                field[k][j-1]++;
                            }
                            if(isValid(field, k, j+1)) { // mid right
                                field[k][j+1]++;
                            }
                            if(isValid(field, k+1, j-1)) { // bot left
                                field[k+1][j-1]++;
                            }
                            if(isValid(field, k+1, j)) { // bot mid
                                field[k+1][j]++;
                            }
                            if(isValid(field, k+1, j+1)) { // bot right
                                field[k+1][j+1]++;
                            }
                        }
                    }
                }
            }

            for(int k = 0; k < 10; k++) {
                for(int j = 0; j < 10; j++) {
                    if(field[k][j] != 0) {
                        isAllFlashed = false;
                        break;
                    }
                }
            }

            if(isAllFlashed) {
                System.out.println(i+1);
                isAllFlashed = false;
            } else {
                isAllFlashed = true;
            }
        }
    }
    
    public static boolean isValid(int[][] map, int row, int col) {

        if(row < 0 || col < 0) return false;
        else if(row >= 10 || col >= 10) return false;
        else if(map[row][col] == 0) return false;
        else return true;
    }
}