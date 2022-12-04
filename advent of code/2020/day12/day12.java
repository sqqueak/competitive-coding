// Rain Risk

package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day12 {

    public static void main(String[] args){
        part1();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day12\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        // there will be two main arrays that account for direction and movement
        char[] directions = new char[inputs.size()];
        int[] movement = new int[inputs.size()];

        // separating the string into direction (nsew/flr) and movement
        int counter = 0;
        for(String str : inputs) {
            directions[counter] = str.charAt(0);
            String[] temp = str.split("[W]|[N]|[F]|[E]|[L]|[R]|[S]");
            movement[counter] = Integer.parseInt(temp[1]);
            counter++;
        }

        // performing each action
        int deltaHorizontal = 0;
        int deltaVertical = 0;
        char face = 'E';
        for(int i = 0; i < inputs.size(); i++) {
            System.out.println("(" + deltaHorizontal + "," + deltaVertical + ")");
            System.out.println(directions[i] + " " + movement[i]);
            switch(directions[i]) {
                case 'F':
                    if(face == 'N') {
                        deltaVertical += movement[i];
                    } else if(face == 'S') {
                        deltaVertical -= movement[i];
                    } else if(face == 'E') {
                        deltaHorizontal += movement[i];
                    } else if(face == 'W') {
                        deltaHorizontal -= movement[i];
                    }
                    break;
                
                case 'L':
                    face = changeDirection('L', face, movement[i]);
                    break;

                case 'R':
                    face = changeDirection('R', face, movement[i]);
                    break;

                case 'N':
                    deltaVertical += movement[i];
                    break;

                case 'S':
                    deltaVertical -= movement[i];
                    break;

                case 'E':
                    deltaHorizontal += movement[i];
                    break;

                case 'W':
                    deltaHorizontal -= movement[i];
                    break;
            }
        }

        System.out.println(Math.abs(deltaHorizontal) + Math.abs(deltaVertical));
    }

    public static char changeDirection(char turn, char face, int degrees) {
        // System.out.print(face + " " + turn + " " + degrees +": ");
        if(turn == 'R') {
            char[] directions = {'N', 'E', 'S', 'W'};
            int turnIndex = degrees / 90;
            if(face == 'N') {
                face = directions[turnIndex];
            } else if(face == 'E') {
                face = directions[(turnIndex + 1)% 4];
            } else if(face == 'S') {
                face = directions[(turnIndex + 2)% 4];
            } else if(face == 'W') {
                face = directions[(turnIndex + 3)% 4];
            }
        } else if(turn == 'L') {
            char[] directions = {'N', 'W', 'S', 'E'};
            int turnIndex = degrees / 90;
            if(face == 'N') {
                face = directions[turnIndex];
            } else if(face == 'E') {
                face = directions[(turnIndex + 3)% 4];
            } else if(face == 'S') {
                face = directions[(turnIndex + 2)% 4];
            } else if(face == 'W') {
                face = directions[(turnIndex + 1)% 4];
            }
        }

        // System.out.println(face);
        return face;
    }
}
