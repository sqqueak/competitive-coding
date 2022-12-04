// Binary Boarding

package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day5 {
    public static void main(String args[]) {
        part2();
    }

    public static int[] findSeat(String code) {
        int[] position = {0, 0, 0}; // row, column, seatID
        int[] rowPos = {0, 127};
        int[] colPos = {0, 7};

        char[] rowID = code.split("(R|L){3}")[0].toCharArray();
        char[] colID = code.split("(B|F){7}")[1].toCharArray();

        for(char character : rowID) {
            int half = (rowPos[1] - rowPos[0]) / 2;
            int row = 0;

            if(half == 1) {
                if(character == 'F') { 
                    row = rowPos[0];
                } else if(character == 'B') {
                    row = rowPos[1];
                }
            } else {
                if(character == 'F') {
                    rowPos[1] -= half;
                } else if(character == 'B') {
                    rowPos[0] += half;
                }
            }

            position[0] = row;
        }

        for(char character : colID) {
            int half = (colPos[1] - colPos[0]) / 2;
            int col = 0;

            if(half == 1) {
                if(character == 'L') { 
                    col = colPos[0];
                } else if(character == 'R') {
                    col = colPos[1];
                }
            } else {
                if(character == 'L') {
                    colPos[1] -= half;
                } else if(character == 'R') {
                    colPos[0] += half;
                }
            }

            position[1] = col;
        }

        return position;
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day5\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<int[]> positions = new ArrayList<>();
        
        for(String line : inputs) {
            positions.add(findSeat(line));
        }

        int largest = 0;
        for(int[] coords : positions) {
            coords[2] = (coords[0] * 8) + coords[1];
            if(coords[2] > largest) largest = coords[2];
        }

        System.out.println(largest);
    }

    public static void part2() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day5\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        ArrayList<int[]> positions = new ArrayList<>();
        
        for(String line : inputs) {
            positions.add(findSeat(line));
        }

        for(int[] coords : positions) {
            //System.out.println("{ " + coords[0] + ", " + coords[1] + " }");
        }

        String[][] seatsTaken = new String[128][8];

        for(int[] coords : positions) {
            seatsTaken[coords[0]][coords[1]] = "X";
            //System.out.println(coords[0] + "   " + coords[1]);
        }

        for(int row = 0; row < seatsTaken.length; row++) {
            for(int col = 0; col < seatsTaken[0].length; col++) {
                if(seatsTaken[row][col] == null) {
                    //System.out.println(row + " " + col);
                }
            }
        }

        for(int row = 0; row < seatsTaken.length; row++) {
            String seats = "";
            for(int col = 0; col < seatsTaken[0].length; col++) {
                if(seatsTaken[row][col] == null) {
                    seats += "_";
                } else {
                    seats += seatsTaken[row][col];
                }
            }
            System.out.println(seats);
        }

    }
    
}
