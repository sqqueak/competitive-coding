/**
 * Advent of Code 2021 - Day 3: Binary Diagnostic
 * 2 December 2021 - 3 December 2021
 * 
 * part 1: 12 minutes
 * part 2: 150 minutes :(
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("inputs/day3.txt");

        Scanner sc = new Scanner(input);
        ArrayList<char[]> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine().toCharArray());
        }

        String gamma = "";
        String epsilon = "";

        for(int i = 0; i < inputs.get(0).length; i++) {
            int counter0 = 0;
            int counter1 = 0;
            for(int j = 0; j < inputs.size(); j++) {
                char[] curr = inputs.get(j);
                if(curr[i] == '0') {
                    counter0++;
                } else {
                    counter1++;
                }
            }

            if(counter0 > counter1) {
                gamma += "0";
                epsilon += "1";
            } else if(counter1 > counter0) {
                gamma += "1";
                epsilon += "0";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }

        System.out.println(gamma);
        System.out.println(epsilon);

        sc.close();

        //System.out.println(2346*1749);

        // part 2

        char[] oxygen = gamma.toCharArray();
        char[] co2 = epsilon.toCharArray();

        LinkedList<char[]> oxygenQ = new LinkedList<>();
        for(char[] in : inputs) {
            oxygenQ.add(in);
        }

        LinkedList<char[]> co2Q = new LinkedList<>();
        for(char[] in : inputs) {
            co2Q.add(in);
        }

        for(int i = 0; i < gamma.toCharArray().length; i++) {
            char[] firstItem = null;
            while(oxygenQ.size() > 1) {
                if(oxygenQ.peek()[i] == oxygen[i]) {
                    if(firstItem == null) firstItem = oxygenQ.peek();
                    oxygenQ.add(oxygenQ.pop());
                } else {
                    oxygenQ.pop();
                }
                if(firstItem == oxygenQ.peek()) {
                    break;
                }
            }

            System.out.println("SIZE: "+oxygenQ.size());

            if(oxygenQ.size() == 1) {
                break;
            }

            int counter0 = 0;
            int counter1 = 0;

            for(int j = 0; j < oxygenQ.size(); j++) {
                if(oxygenQ.peek()[i+1] == '0') {
                    counter0++;
                } else {
                    counter1++;
                }
                oxygenQ.add(oxygenQ.pop());
            }

            if(counter0 > counter1) {
                oxygen[i+1] = '0';
                //System.out.println(counter0 + " : " + 0);
            } else {
                oxygen[i+1] = '1';
                //System.out.println(counter1 + " : " + 1);
            }

            //System.out.println(oxygen);
        }

        for(int i = 0; i < epsilon.toCharArray().length; i++) {
            char[] firstItem = null;
            while(co2Q.size() > 1) {
                if(co2Q.peek()[i] == co2[i]) {
                    if(firstItem == null) {
                        firstItem = co2Q.peek();
                    }
                    //System.out.println(co2Q.peek());
                    char[] add = co2Q.pop();
                    co2Q.add(add);
                } else {
                    co2Q.pop();
                }

                if(firstItem == co2Q.peek()) {
                    break;
                }
            }

            //System.out.println("SIZE: "+co2Q.size());

            if(co2Q.size() == 1) {
                break;
            }

            int counter0 = 0;
            int counter1 = 0;

            for(char[] li : co2Q) {
                if(li[i+1] == '0') {
                    counter0++;
                } else {
                    counter1++;
                }
            }

            if(counter0 > counter1) {
                co2[i+1] = '1';
                //System.out.println(counter1 + " : " + 1);

            } else {
                co2[i+1] = '0';
                //System.out.println(counter1 + " : " + 0);

            }

            //System.out.println(co2);
        }

        System.out.println(oxygenQ.pop());
        System.out.println(co2Q.pop());















        // // oxygen generator using gamma
        // char[] gammaArray = gamma.toCharArray();

        // // two placement arraylists
        // ArrayList<char[]> oxygen = new ArrayList<>();

        // ArrayList<char[]> q = new ArrayList<>();
        // oxygen = inputs;

        // for(int i = 0; i < oxygen.size(); i++) {
        //     if(oxygen.get(i)[0] == gammaArray[0]) {
        //         q.add(oxygen.get(i));
        //     }
        // }

        // int counter = 1;
        // System.out.println(q.size());
        // int siz = q.size();

        // while(q.size() > 1) {
        //     System.out.println("INPUTS: " + q.size());

        //     for(int i = 0; i < siz; i++) {

        //         if(q.size() == 1) {
        //             break;
        //         }
        //         if(q.get(0)[counter] == gammaArray[counter]) {
        //             q.add(q.remove(0));
        //         } else {
        //             q.remove(0);
        //         }
                
        //     }
        //     counter++;
        //     if(counter == 12) {
        //         break;
        //     }
        // }

        // System.out.println(q.size());

        // for(char c : q.remove(0)) {
        //     System.out.print(c);
        // }

        // // co2 gen with epsilon
        // System.out.println();

        // char[] epsilonArray = epsilon.toCharArray();

        // // two placement arraylists
        // ArrayList<char[]> co2 = new ArrayList<>();

        // ArrayList<char[]> q2 = new ArrayList<>();


        // co2 = inputs;

        // for(int i = 0; i < co2.size(); i++) {
        //     if(co2.get(i)[0] == epsilonArray[0]) {
        //         q2.add(co2.get(i));
        //     }
        // }

        // System.out.println("INPUTS: " + q2.size());

        // int counter2 = 1;
        // int siz2 = q2.size();

        // while(q2.size() > 1) {
        //     System.out.println("INPUTS: " + q2.size());

        //     for(int i = 0; i < siz2; i++) {
        //         if(q2.size() == 1) {
        //             break;
        //         }

        //         if(q2.get(0)[counter2] == epsilonArray[counter2]) {
        //             q2.add(q2.remove(0));
        //         } else {
        //             q2.remove(0);
        //         }
                
        //     }

        //     counter2++;
        //     if(counter2 == 12) {
        //         break;
        //     }
        // }

        // for(char c : q2.remove(0)) {
        //     System.out.print(c);
        // }
        
    }
}