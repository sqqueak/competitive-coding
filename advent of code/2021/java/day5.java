/**
 * Advent of Code 2021 - Day 5: Hydrothermal Venture
 * 4 December 2021 - 5 December 2021
 * 
 * part 1: 24 minutes
 * part 2: 49 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day5 {

    public static void part1() throws FileNotFoundException{
        File input = new File("inputs/day5.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String[]> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine().split(" -> "));
        }

        sc.close();

        ArrayList<int[]> starts = new ArrayList<>();
        ArrayList<int[]> ends = new ArrayList<>();

        // for(String[] in : inputs) {
        //     System.out.println(in[0]);
        // }

        for(String[] startAndEnd : inputs) {
            String[] start = startAndEnd[0].split(",");
            String[] end = startAndEnd[1].split(",");

            int[] startNum = { Integer.parseInt(start[0]) , Integer.parseInt(start[1]) };
            int[] endNum = { Integer.parseInt(end[0]) , Integer.parseInt(end[1]) };

            starts.add(startNum);
            ends.add(endNum);
        }

        // for(int[] coords : starts) {
        //     System.out.println(coords[0] + " " + coords[1]);
        // }

        int[][] BOARD = new int[999][999];

        for(int i = 0; i < inputs.size(); i++) {
            int[] start = starts.get(i);
            int[] end = ends.get(i);

            if(start[0] == end[0]) { // horizontal
                for(int col = Math.min(start[1], end[1]); col <= Math.max(start[1], end[1]); col++) {
                    BOARD[start[0]][col]++;
                }
                // System.out.println(BOARD[start[0]][start[1]]);
                // System.out.println(BOARD[end[0]][end[1]]);
                // System.out.println("horizontal");
                
            } else if(start[1] == end[1]) { // vertical
                for(int row = Math.min(start[0], end[0]); row <= Math.max(start[0], end[0]); row++) {
                    BOARD[row][start[1]]++;
                }
                // System.out.println(BOARD[start[0]][start[1]]);
                // System.out.println(BOARD[end[0]][end[1]]);
                // System.out.println("vertical");
            } 
        }

        int overlap = 0;

        for(int i = 0; i < 999; i++) {
            for(int j = 0; j < 999; j++) {
                if(BOARD[i][j] >= 2) {
                    overlap++;
                }
            }
        }

        System.out.println(overlap);

    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("inputs/day5.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String[]> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine().split(" -> "));
        }

        ArrayList<int[]> starts = new ArrayList<>();
        ArrayList<int[]> ends = new ArrayList<>();

        // for(String[] in : inputs) {
        //     System.out.println(in[0]);
        // }

        for(String[] startAndEnd : inputs) {
            String[] start = startAndEnd[0].split(",");
            String[] end = startAndEnd[1].split(",");

            int[] startNum = { Integer.parseInt(start[0]) , Integer.parseInt(start[1]) };
            int[] endNum = { Integer.parseInt(end[0]) , Integer.parseInt(end[1]) };

            starts.add(startNum);
            ends.add(endNum);
        }

        sc.close();

        // for(int[] coords : starts) {
        //     System.out.println(coords[0] + " " + coords[1]);
        // }

        int[][] BOARD = new int[999][999];

        for(int i = 0; i < inputs.size(); i++) {
            int[] start = starts.get(i);
            int[] end = ends.get(i);

            if(start[0] == end[0]) { // horizontal
                for(int col = Math.min(start[1], end[1]); col <= Math.max(start[1], end[1]); col++) {
                    BOARD[start[0]][col]++;
                }
                // System.out.println(BOARD[start[0]][start[1]]);
                // System.out.println(BOARD[end[0]][end[1]]);
                // System.out.println("horizontal");
                
            } else if(start[1] == end[1]) { // vertical
                for(int row = Math.min(start[0], end[0]); row <= Math.max(start[0], end[0]); row++) {
                    BOARD[row][start[1]]++;
                }
                // System.out.println(BOARD[start[0]][start[1]]);
                // System.out.println(BOARD[end[0]][end[1]]);
                // System.out.println("vertical");
            } else {
                int rowStart = start[0];
                int rowEnd = end[0];
                int colStart = start[1];
                int colEnd = end[1];

                int colMod = start[1];
                int rowMod = start[0];
                System.out.println(rowStart + " " + rowEnd + "  " + colStart + " " + colEnd);

                if(rowStart < rowEnd && colStart < colEnd) {
                    for(int row = rowStart; row <= rowEnd; row++) {
                        BOARD[row][colMod]++;
                        colMod++;
                        //System.out.print("1");
                    }
                } else if(rowStart < rowEnd && colStart > colEnd) {
                    for(int row = rowStart; row <= rowEnd; row++) {
                        BOARD[row][colMod]++;
                        colMod--;
                        //System.out.print("2");
                        //System.out.println(row + ":" + colStart);
                    }
                } else if(rowStart > rowEnd && colStart < colEnd) {
                    for(int col = colStart; col <= colEnd; col++) {
                        BOARD[rowMod][col]++;
                        rowMod--;
                        //System.out.print("3");
                        //System.out.println(rowMod + ":" + col);
                    }
                } else if(rowStart > rowEnd && colStart > colEnd) {
                    for(int col = colStart; col >= colEnd; col--) {
                        BOARD[rowMod][col]++;
                        rowMod--;
                        //System.out.print("4");
                        //System.out.println(rowMod + ":" + col);
                    }
                } else {
                    System.out.println("MMM");
                }
                


                // for(int row = Math.min(start[0], end[0]); row <= Math.max(start[0], end[0]); row++) {

                //     BOARD[row][colStart]++;

                //     if(initialRow == start[0]) {
                //         if(start[1] < end[1]) {
                //             colStart++;
                //         } else {
                //             colStart--;
                //         }

                //     } else if(initialRow == end[0]) {
                //         if(start[1] < end[1]) {
                //             colStart++;
                //         } else {
                //             colStart--;
                //         }
                //     } else {
                //         System.out.println("FUCK");
                //     }

                //     BOARD[row][colStart]++;

                //     //System.out.print(row + " " + colStart + "; ");
                // }

                //System.out.println();
                //System.out.println();
            }
        }

        int overlap = 0;

        for(int i = 0; i < 999; i++) {
            for(int j = 0; j < 999; j++) {
                if(BOARD[i][j] >= 2) {
                    overlap++;
                }
            }
        }

        System.out.println(overlap);

    }
}