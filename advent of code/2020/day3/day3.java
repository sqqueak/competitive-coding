// Toboggan Trajectory

package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        ArrayList<String> lines = new ArrayList<>();

        File input = new File("day3\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        char[][] map = new char[lines.get(0).length()][lines.size()];

        for(int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();

            for(int k = 0; k < chars.length; k++) {
                map[k][i] = chars[k];
            }
        }

        int counter = 0;
        int trees = 0;
        int[] currentPos = {0,0};

        while(!(counter == lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees++;
            }

            if(currentPos[0] + 3 > 30) {
                currentPos[0] -= 28;
                currentPos[1] += 1;
                counter++;

            } else {
                currentPos[0] += 3;
                currentPos[1] += 1;
                counter++;
            }
        }

        System.out.println(trees);
    }

    public static void part2() {
        ArrayList<String> lines = new ArrayList<>();

        File input = new File("day3\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        char[][] map = new char[lines.get(0).length()][lines.size()];

        for(int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();

            for(int k = 0; k < chars.length; k++) {
                map[k][i] = chars[k];
            }
        }

        int counter = 0;
        int trees11 = 0;
        int[] currentPos = {0,0};

        while(!(counter >= lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees11++;
            }

            if(currentPos[0] + 1 > 30) {
                currentPos[0] -= 30;
                currentPos[1] += 1;
                counter++;
                
            } else {
                currentPos[0] += 1;
                currentPos[1] += 1;
                counter++;
            }
        }

        // System.out.println(trees11);

        counter = 0;
        int trees31 = 0;
        currentPos[0] = 0;
        currentPos[1] = 0;

        while(!(counter >= lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees31++;
            }

            if(currentPos[0] + 3 > 30) {
                currentPos[0] -= 28;
                currentPos[1] += 1;
                counter++;
                
            } else {
                currentPos[0] += 3;
                currentPos[1] += 1;
                counter++;
            }
        }

        // System.out.println(trees31);

        counter = 0;
        int trees51 = 0;
        currentPos[0] = 0;
        currentPos[1] = 0;

        while(!(counter >= lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees51++;
            }

            if(currentPos[0] + 5 > 30) {
                currentPos[0] -= 26;
                currentPos[1] += 1;
                counter++;
                
            } else {
                currentPos[0] += 5;
                currentPos[1] += 1;
                counter++;
            }
        }

        // System.out.println(trees51);

        counter = 0;
        int trees71 = 0;
        currentPos[0] = 0;
        currentPos[1] = 0;

        while(!(counter >= lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees71++;
            }

            if(currentPos[0] + 7 > 30) {
                currentPos[0] -= 24;
                currentPos[1] += 1;
                counter++;
                
            } else {
                currentPos[0] += 7;
                currentPos[1] += 1;
                counter++;
            }
        }

        // System.out.println(trees71);

        counter = 0;
        int trees12 = 0;
        currentPos[0] = 0;
        currentPos[1] = 0;

        while(!(counter >= lines.size())) {
            if(map[currentPos[0]][currentPos[1]] == '#') {
                trees12++;
            }

            if(currentPos[0] + 1 > 30) {
                currentPos[0] -= 30;
                currentPos[1] += 2;
                counter += 2;
                
            } else {
                currentPos[0] += 1;
                currentPos[1] += 2;
                counter += 2;
            }
        }

        // System.out.println(trees12);

        System.out.println("Final number too big to handle.");
        System.out.println("93 * 164 * 82 * 91 * 44 = 5007658656");

    }
}