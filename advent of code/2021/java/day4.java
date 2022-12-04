/**
 * Advent of Code 2021 - Day 4: Giant Squid
 * 3 December 2021 - 4 December 2021
 * 
 * part 1: 52 minutes
 * part 2: 35 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class day4 {

    public static boolean checkForWin(int[][] board) {
        // checking rows
        for(int row = 0; row < 5; row++) {
            if(board[row][0] == board[row][1] &&
                board[row][0] == board[row][2] &&
                board[row][0] == board[row][3] &&
                board[row][0] == board[row][4]) {
                    return true;
            }

            if(board[0][row] == board[1][row] &&
                board[0][row] == board[2][row] &&
                board[0][row] == board[3][row] &&
                board[0][row] == board[4][row]) {
                    return true;
            }
        }

        return false;
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day4.txt");

        Scanner sc = new Scanner(input);

        String[] drawnStrings = sc.nextLine().split(",");
        ArrayList<Integer> drawn = new ArrayList<>();
        for(String d : drawnStrings)  {
            drawn.add(Integer.parseInt(d));
        } // all first line input

        ArrayList<int[][]> boards = new ArrayList<>();
        sc.nextLine();

        while(sc.hasNextLine()) {
            String currLine = sc.nextLine();
            if(currLine.isBlank()) {
                //System.out.println("BLANK");
            } else {
                int[][] currBoard = new int[5][5];
                for(int i = 0; i < 5; i++) {

                    String[] currArray = currLine.split("\\s\\s|\\s");

                        int counter = 0;
                        for(String line : currArray) {
                            if(!line.isEmpty()) {currBoard[i][counter] = Integer.parseInt(line);
                            counter++;}
                        }
                    
                    //System.out.println(currLine);
                    if(sc.hasNextLine()) {
                        currLine = sc.nextLine();
                    } else {
                        break;
                    }
                }
                boards.add(currBoard);
            }            
        }

        sc.close();

        // for(int[][] board : boards) {
        //     for(int i = 0; i < 5; i++) {
        //         for(int j = 0; j < 5; j++) {
        //             System.out.print(board[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        HashMap<int[][], LinkedList<Integer>> map = new HashMap<>();

        for(int[][] board : boards) {
            map.put(board, new LinkedList<Integer>());
        }

        // start putting in bingos

        int[][] winBoard = boards.get(0);

        do {
            int currNum = drawn.remove(0);
            for(int[][] board : boards) { // checking EACH BOARD
                
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5; j++) {
                        if(board[i][j] == currNum) {
                            board[i][j] = 100;
                            map.get(board).add(currNum);
                            break;
                        }
                    }
                }

                if(checkForWin(board)) {
                    winBoard = board;
                }
                // boards.remove(currBoard);
                // boards.add(currBoard);
                // currBoard = boards.get(0);
            }

        } while(checkForWin(winBoard) == false);

        int unchecked = 0;

        for(int[] i : winBoard) {
            for(int j : i) {
                if(j != 100) {
                    unchecked += j;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }

        LinkedList<Integer> winList = map.get(winBoard);
        for(int val : winList) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println(unchecked);
        System.out.println(unchecked * winList.getLast());
    }
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("inputs/day4.txt");

        Scanner sc = new Scanner(input);

        String[] drawnStrings = sc.nextLine().split(",");
        ArrayList<Integer> drawn = new ArrayList<>();
        for(String d : drawnStrings)  {
            drawn.add(Integer.parseInt(d));
        } // all first line input

        ArrayList<int[][]> boards = new ArrayList<>();
        sc.nextLine();

        while(sc.hasNextLine()) {
            String currLine = sc.nextLine();
            if(currLine.isBlank()) {
                //System.out.println("BLANK");
            } else {
                int[][] currBoard = new int[5][5];
                for(int i = 0; i < 5; i++) {

                    String[] currArray = currLine.split("\\s\\s|\\s");

                        int counter = 0;
                        for(String line : currArray) {
                            if(!line.isEmpty()) {currBoard[i][counter] = Integer.parseInt(line);
                            counter++;}
                        }
                    
                    //System.out.println(currLine);
                    if(sc.hasNextLine()) {
                        currLine = sc.nextLine();
                    } else {
                        break;
                    }
                }
                boards.add(currBoard);
            }            
        }

        sc.close();

        HashMap<int[][], LinkedList<Integer>> map = new HashMap<>();

        for(int[][] board : boards) {
            map.put(board, new LinkedList<Integer>());
        }

        // start putting in bingos

        int[][] winBoard = boards.get(0);
        LinkedList<Integer> winList = map.get(winBoard);

        do {
            //System.out.println(map.size());

            int currNum = drawn.remove(0);
            for(int[][] board : boards) { // checking EACH BOARD
                
                if(map.containsKey(board)) {
                    for(int i = 0; i < 5; i++) {
                        for(int j = 0; j < 5; j++) {
                            if(board[i][j] == currNum) {
                                board[i][j] = 100;
                                map.get(board).add(currNum);

                                break;
                            }
                        }
                    }

                    if(checkForWin(board) && map.size() > 1) {
                        map.remove(board);
                    } else if(checkForWin(board) && map.size() == 1) {
                        System.out.println(map.size());
                        winList = map.get(board);
                        winBoard = board;
                        map.remove(board);
                    }
                }

                

                // boards.remove(currBoard);
                // boards.add(currBoard);
                // currBoard = boards.get(0);
            }
            //System.out.println(map.size());

            //System.out.println(map.size());

        } while(map.size() != 0);

        int unchecked = 0;

        for(int[] i : winBoard) {
            for(int j : i) {
                if(j != 100) {
                    unchecked += j;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for(int val : winList) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println(unchecked);
        System.out.println(unchecked * winList.getLast());
    }
}