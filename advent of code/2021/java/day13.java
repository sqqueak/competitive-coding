/**
 * Advent of Code 2021 - Day 13: Transparent Origami
 * 15 December 2021
 * 
 * part 1: 100 minutes
 * part 2: 8 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day13 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day13.txt");

        Scanner sc = new Scanner(input);
        ArrayList<int[]> inputs = new ArrayList<>();
        ArrayList<String[]> instructions = new ArrayList<>();
        String currLine = sc.nextLine();

        while(sc.hasNextLine() && !currLine.isEmpty()) {
            String[] temp = currLine.split(",");
            inputs.add(new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])}) ;
            currLine = sc.nextLine();
        }

        while(sc.hasNextLine()) {
            currLine = sc.nextLine();
            String[] temp = currLine.split(" ");
            instructions.add(temp[2].split("="));
        }
        sc.close();

        // for(String[] in : instructions) {
        //     for(String i : in) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }

        // finding array dimensions
        int largestX = 0;
        int largestY = 0;

        for(int[] in : inputs) {
            if(in[0] > largestX) largestX = in[0];
            if(in[1] > largestY) largestY = in[1];
        }
        
        largestX++;
        largestY++;

        char[][] paper = new char[largestY][largestX];

        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j < paper[0].length; j++) {
                paper[i][j] = '.';
            }
        }

        for(int[] in : inputs) {
            paper[in[1]][in[0]] = '#';
        }

        
        paper = foldPaper(paper, instructions.get(0)[0], Integer.parseInt(instructions.get(0)[1]));
        //paper = foldPaper(paper, instructions.get(1)[0], Integer.parseInt(instructions.get(1)[1]));

        int dots = 0;

        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j < paper[0].length; j++) {
                if(paper[i][j] == '#') dots++;
                //System.out.print(paper[i][j]);
            }
            //System.out.println();
        }
        System.out.println(dots);
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day13.txt");

        Scanner sc = new Scanner(input);
        ArrayList<int[]> inputs = new ArrayList<>();
        ArrayList<String[]> instructions = new ArrayList<>();
        String currLine = sc.nextLine();

        while(sc.hasNextLine() && !currLine.isEmpty()) {
            String[] temp = currLine.split(",");
            inputs.add(new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])}) ;
            currLine = sc.nextLine();
        }

        while(sc.hasNextLine()) {
            currLine = sc.nextLine();
            String[] temp = currLine.split(" ");
            instructions.add(temp[2].split("="));
        }
        sc.close();

        // for(String[] in : instructions) {
        //     for(String i : in) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }

        // finding array dimensions
        int largestX = 0;
        int largestY = 0;

        for(int[] in : inputs) {
            if(in[0] > largestX) largestX = in[0];
            if(in[1] > largestY) largestY = in[1];
        }
        
        largestX++;
        largestY++;

        char[][] paper = new char[largestY][largestX];

        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j < paper[0].length; j++) {
                paper[i][j] = '.';
            }
        }

        for(int[] in : inputs) {
            paper[in[1]][in[0]] = '#';
        }

        for(int i = 0; i < instructions.size(); i++) {
            paper = foldPaper(paper, instructions.get(i)[0], Integer.parseInt(instructions.get(i)[1]));
        }

        for(int i = 0; i < paper.length; i++) {
            for(int j = 0; j < paper[0].length; j++) {
                System.out.print(paper[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] foldPaper(char[][] paper, String dir, int coord) {
        if(dir.equals("x")) {
            char[][] foldedPaper = new char[paper.length][coord];
            for(int i = 0; i < paper.length; i++) {
                for(int j = 0; j < coord; j++) {
                    foldedPaper[i][j] = paper[i][j];
                }
            }

            int counter = 2;
            for(int i = 0; i < paper.length; i++) { 
                for(int j = coord+1; j < paper[0].length; j++) {
                    if(paper[i][j] != '.') { foldedPaper[i][j-counter] = paper[i][j]; }
                    counter += 2; // unsure why y-coord is different from x-coord code
                }
                //System.out.println();
                counter = 2;
            }
            return foldedPaper;

        } else {
            char[][] foldedPaper = new char[coord][paper[0].length];
            for(int i = 0; i < coord; i++) { //  each row (y-coord)
                for(int j = 0; j < paper[0].length; j++) {
                    foldedPaper[i][j] = paper[i][j];
                }
            }

            int counter = 2;
            for(int i = coord+1; i < paper.length; i++) { // folding over the paper. copying #s
                for(int j = 0; j < paper[0].length; j++) {
                    if(paper[i][j] != '.') { foldedPaper[i-counter][j] = paper[i][j]; };
                }
                counter += 2;
            }
            return foldedPaper;
        }
    }
}