/**
 * Advent of Code 2021 - Day 8: Seven Segment Search
 * 8 December 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class day8 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day8.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }

        List<String[]> filtered = Stream.of(inputs.toArray(new String[0]))
            .map(i -> i.split(" \\| ")[1].split(" "))
            .toList();

        // working with STREAMS
        // input in array form, Stream.of(array) and collect at the end

        int counter = 0;

        for(String[] item : filtered) {
            for(String m : item){
                if(m.length() == 2 || m.length() == 3 || m.length() == 4 || m.length() == 7) {
                    counter++;
                    //System.out.println(m);
                }
            }
            // System.out.println();
        }

        System.out.println(counter);
        sc.close();
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day8.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }

        List<String[]> codes = Stream.of(inputs.toArray(new String[0]))
                .map(i -> i.split(" \\| ")[0].split(" "))
                .toList();

        List<String[]> digits = Stream.of(inputs.toArray(new String[0]))
                .map(i -> i.split(" \\| ")[1].split(" "))
                .toList();

        // working with STREAMS
        // input in array form, Stream.of(array) and collect at the end

        int finNum = 0;

        for(int i = 0; i < codes.size(); i++) { // for every input line
            String[] keys = new String[10];
            boolean isSolved = false;

            while(!isSolved) {
                for(String key : codes.get(i)) {
                    if(key.length() == 2) {
                        keys[1] = key;
                    } else if(key.length() == 3) {
                        keys[7] = key; 
                    } else if(key.length() == 4) {
                        keys[4] = key;
                    } else if(key.length() == 7) {
                        keys[8] = key;
                    } else {
                        if(key.length() == 6 && keys[1] != null && keys[4] != null ) { // 6 slots turn on, testing for 9, 0, 6
                            boolean isAllTrue = false;
                        
                            for(char dex : keys[4].toCharArray()) { // getting all chars from 1 display
                                if(key.contains(Character.toString(dex))) {
                                    isAllTrue = true;
                                } else {
                                    isAllTrue = false;
                                    break;
                                }
                            }

                            if(isAllTrue) { // if key contains same slots as 4, we know it's 9
                                keys[9] = key;
                            } else { 
                                for(char dex : keys[1].toCharArray()) { // getting all chars from 4 display
                                    if(key.contains(Character.toString(dex))) {
                                        isAllTrue = true;
                                    } else {
                                        isAllTrue = false;
                                        break;
                                    }
                                }

                                if(isAllTrue) {
                                    keys[0] = key;
                                } else {
                                    keys[6] = key;
                                }
                            }

                        } else if(keys[1] != null && keys[6] != null) { // 5 slots turn on, testing for 3, 5, 2
                            boolean isAllTrue = false;

                            for(char dex : keys[1].toCharArray()) { // getting all chars from 1 display
                                if(key.contains(Character.toString(dex))) {
                                    isAllTrue = true;
                                } else {
                                    isAllTrue = false;
                                    break;
                                }
                            }

                            if(isAllTrue) {
                                keys[3] = key;
                            } else {
                                for(char dex : key.toCharArray()) { // getting all chars from 1 display
                                    if(keys[6].contains(Character.toString(dex))) {
                                        isAllTrue = true;
                                    } else {
                                        isAllTrue = false;
                                        break;
                                    }
                                }

                                if(isAllTrue) {
                                    keys[5] = key;
                                } else {
                                    keys[2] = key;
                                }
                            }                    
                        }
                    }

                    for(String k : keys) {
                        //System.out.print(k + " ");
                        if(k == null) {
                            isSolved = false;
                            break;
                        } else {
                            isSolved = true;
                        }
                    }
                    //System.out.println();
                    //System.out.println("LOOP");
                }

                for (String key : keys) {
                    System.out.print(key);
                    System.out.println();
                }
            }

            String[] digit = digits.get(i);
            String num = "";

            for(String dig : digit) {
                for(String key : keys) {
                    char[] keyLetters = key.toCharArray();
                    char[] digitLetters = dig.toCharArray();

                    Arrays.sort(keyLetters);
                    Arrays.sort(digitLetters);

                    if(Arrays.equals(keyLetters, digitLetters)) {
                        num += Arrays.asList(keys).indexOf(key);
                        break;
                    }
                }
            }

            finNum += Integer.parseInt(num);
        }

        System.out.println(finNum);
        sc.close();
    }
}