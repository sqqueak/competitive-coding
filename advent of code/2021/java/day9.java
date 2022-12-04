/**
 * Advent of Code 2021 - Day 9: Smoke Basin
 * 8 December 2021 - 9 December 2021
 * 
 * part 1: 22 minutes
 * part 2: ~i forgot dfs so i simply will not do it~ i did dfs in class and then couldn't figure out how to sort the arraylist 
 * about 150 minutes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class day9 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day9.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }

        int[][] heatmap = new int[inputs.size()][inputs.get(0).toCharArray().length];

        for(int i = 0; i < inputs.size(); i++) {
            for(int j = 0; j < inputs.get(0).length(); j++) {
                heatmap[i][j] = Character.getNumericValue(inputs.get(i).toCharArray()[j]);
            }
        }

        int counter = 0;

        for(int i = 0; i < heatmap.length; i++) {
            for(int j = 0; j < heatmap[0].length; j++) {
                if(i == 0 && j == 0) { // top left corner
                    if(heatmap[1][0] > heatmap[0][0] && heatmap[0][1] > heatmap[0][0]) counter++;
                } else if(i == 0 && j == heatmap[0].length-1) { // top right corner
                    if(heatmap[0][heatmap[0].length-2] > heatmap[0][heatmap[0].length-1] && heatmap[1][heatmap[0].length-1] > heatmap[0][heatmap[0].length-1]) counter += heatmap[i][j]+1;
                } else if(i == heatmap.length-1 && j == 0) { // bottom left corner
                    if(heatmap[heatmap.length-2][0] > heatmap[heatmap.length-1][0] && heatmap[heatmap.length-1][1] > heatmap[heatmap.length-1][0]) counter += heatmap[i][j]+1;
                } else if(i == heatmap.length-1 && j == heatmap[0].length-1) { // bottom right corner
                    if(heatmap[heatmap.length-2][heatmap[0].length-1] > heatmap[heatmap.length-1][heatmap[0].length-1] && heatmap[heatmap.length-1][heatmap[0].length-2] > heatmap[heatmap.length-1][heatmap[0].length-1]) counter += heatmap[i][j]+1;
                } else if(i == 0) { // first row
                    if(heatmap[0][j-1] > heatmap[0][j] && heatmap[0][j+1] > heatmap[0][j] && heatmap[1][j] > heatmap[i][j]) counter += heatmap[i][j]+1;
                } else if(j == 0) { // first column
                    if(heatmap[i-1][0] > heatmap[i][j] && heatmap[i+1][0] > heatmap[i][j] && heatmap[i][1] > heatmap[i][j]) counter += heatmap[i][j]+1;
                } else if(i == heatmap.length-1) { // last row
                    if(heatmap[heatmap.length-1][j-1] > heatmap[i][j] && heatmap[heatmap.length-1][j+1] > heatmap[i][j] && heatmap[heatmap.length-2][j] > heatmap[i][j]) counter += heatmap[i][j]+1;
                } else if(j == heatmap[0].length-1) {
                    if(heatmap[i-1][heatmap[0].length-1] > heatmap[i][j] && heatmap[i+1][heatmap[0].length-1] > heatmap[i][j] && heatmap[i][heatmap[0].length-2] > heatmap[i][j]) counter += heatmap[i][j]+1;
                } else {
                    if(heatmap[i-1][j] > heatmap[i][j] && heatmap[i+1][j] > heatmap[i][j] && heatmap[i][j-1] > heatmap[i][j] && heatmap[i][j+1] > heatmap[i][j]) counter += heatmap[i][j]+1;
                }
            }
        } // please don't make fun of me i was tired and stupid

        System.out.println(counter);

        sc.close();
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day9.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }

        int[][] heatmap = new int[inputs.size()][inputs.get(0).toCharArray().length];

        for(int i = 0; i < inputs.size(); i++) {
            for(int j = 0; j < inputs.get(0).length(); j++) {
                heatmap[i][j] = Character.getNumericValue(inputs.get(i).toCharArray()[j]);
            }
        }
        sc.close();

        HashMap<String, Boolean> hashmap = new HashMap<>();
        ArrayList<Integer> basinSizes = new ArrayList<>();
        
        for(int i = 0; i < heatmap.length; i++) {
            for(int j = 0; j < heatmap[0].length; j++) {
                if(heatmap[i][j] != 10) {
                    int size = dfs(new Integer[] {i, j}, heatmap, hashmap, 0);
                    if(size != 0 && size != 1) {
                        basinSizes.add(size);
                    }
                }
            }
        }

        Object[] holder = basinSizes.toArray();
        Arrays.sort(holder);

        System.out.println((int)holder[holder.length-1] * (int)holder[holder.length-2] * (int)holder[holder.length-3]);

        // for(int[] a : heatmap) {
        //     for(int b : a) {
        //         System.out.print(b + " ");
        //     }
        //     System.out.println();
        // }
    }

    // none of this works because i did recursion instead of queues ??

    public static boolean isValid(int[][] map, int row, int col) {

        if(row < 0 || col < 0) return false;
        else if(row >= map.length || col >= map[0].length) return false;
        else if(map[row][col] == 9) return false;
        else return true;
    }

    public static int dfs(Integer[] currCoords, int[][] heatmap, HashMap<String, Boolean> hashmap, int basinSize) {
        //if(currCoords[1] == 1 && currCoords[0] == 1) throw new IllegalAccessError();
        //System.out.println(currCoords[1] + "||" + currCoords[0]);
        //System.out.println(heatmap[currCoords[1]][currCoords[0]]);

        if(isValid(heatmap, currCoords[0], currCoords[1])) { // in the format of col, row or x-axis, y-axis
            hashmap.put(currCoords[0].toString() + currCoords[1].toString(), true); // currBlock is visited
            //System.out.println("COMPARISON 1: " + currCoords[0].toString() + currCoords[1].toString());

            int[] xVector = {0,1,0,-1};
            int[] yVector = {-1,0,1,0};

            //if(hashmap.containsValue(false)) { // if there are unvisited grid blocks
                for(int i = 0; i < 4; i++) {
                    currCoords[0] += xVector[i];
                    currCoords[1] += yVector[i];
                    //System.out.println((currCoords[0]) + ":" + currCoords[1]);
                    //System.out.print(isValid(heatmap, currCoords[0], currCoords[1]) + " ");
                    //System.out.println(!hashmap.containsKey(currCoords.toString()));

                    //System.out.println("COMPARISON 2: " + currCoords[0].toString() + currCoords[1].toString());

                    if(isValid(heatmap, currCoords[0], currCoords[1]) && !hashmap.containsKey(currCoords[0].toString() + currCoords[1].toString())) {
                        //System.out.println("TRUE");
                        basinSize = dfs(new Integer[] {currCoords[0], currCoords[1]}, heatmap, hashmap, basinSize);
                    }

                    currCoords[0] -= xVector[i];
                    currCoords[1] -= yVector[i];

                    if(heatmap[currCoords[0]][currCoords[1]] < 9) { // if switching numbers, they produce the same thing...?
                        //System.out.println("TRUE");
                        heatmap[currCoords[0]][currCoords[1]] = 10; 
                        basinSize += 1;
                    }
                }
            //}
            //if(currCoords[1] == 1 && currCoords[0] == 1) throw new IllegalAccessError();
        }
        return basinSize;
    }
    // working dfs copy in case i fuck up
    /**    public static void dfs(Integer[] currCoords, int[][] heatmap, HashMap<String, Boolean> hashmap) {
        //if(currCoords[1] == 1 && currCoords[0] == 1) throw new IllegalAccessError();
        //System.out.println(currCoords[1] + "||" + currCoords[0]);
        //System.out.println(heatmap[currCoords[1]][currCoords[0]]);

        if(isValid(heatmap, currCoords[0], currCoords[1])) { // in the format of col, row or x-axis, y-axis
            hashmap.put(currCoords[0].toString() + currCoords[1].toString(), true); // currBlock is visited
            //System.out.println("COMPARISON 1: " + currCoords[0].toString() + currCoords[1].toString());

            int[] xVector = {0,1,0,-1};
            int[] yVector = {-1,0,1,0};

            //if(hashmap.containsValue(false)) { // if there are unvisited grid blocks
                for(int i = 0; i < 4; i++) {
                    currCoords[0] += xVector[i];
                    currCoords[1] += yVector[i];
                    //System.out.println((currCoords[0]) + ":" + currCoords[1]);
                    //System.out.print(isValid(heatmap, currCoords[0], currCoords[1]) + " ");
                    //System.out.println(!hashmap.containsKey(currCoords.toString()));

                    //System.out.println("COMPARISON 2: " + currCoords[0].toString() + currCoords[1].toString());

                    if(isValid(heatmap, currCoords[0], currCoords[1]) && !hashmap.containsKey(currCoords[0].toString() + currCoords[1].toString())) {
                        //System.out.println("TRUE");
                        dfs(new Integer[] {currCoords[0], currCoords[1]}, heatmap, hashmap);
                    }

                    currCoords[0] -= xVector[i];
                    currCoords[1] -= yVector[i];
                }
            //}
            //if(currCoords[1] == 1 && currCoords[0] == 1) throw new IllegalAccessError();
        }
    } */
}