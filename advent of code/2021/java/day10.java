/**
 * Advent of Code 2021 - Day 10: Syntax Scoring
 * 10 December 2021
 * 
 * part 1: 20-30 minutes?
 * part 2: more than an hour, probably an hour 20
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class day10 {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File input = new File("inputs/day10.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }
        sc.close();

        List<char[]> filtered = Stream.of(inputs.toArray(new String[0]))
            .map(i -> i.toCharArray())
            .toList();

        int pts = 0;

        for(char[] a : filtered) {
            Stack<Character> ck = new Stack<>();

            for(char b : a) {
                //System.out.println(b);
                if(!isClosed(b)) { // part 1 of corrupted
                    ck.add(b);
                    //System.out.println("j");
                } else {
                    if(!isOpposite(ck.pop(), b)) {
                        switch(b) {
                            case')':
                                pts += 3;
                                break;
                            case']':
                                pts += 57;
                                break;
                            case'}':
                                pts += 1197;
                                break;
                            case'>':
                                pts += 25137;
                                break;
                        }
                    }
                }
            }
        }

        System.out.println(pts);
    }

    public static boolean isOpposite(char stPeek, char curr) {

        if(stPeek == '{' && curr == '}') return true;
        if(stPeek == '[' && curr == ']') return true;
        if(stPeek == '(' && curr == ')') return true;
        if(stPeek == '<' && curr == '>') return true;

        return false;
    }

    public static boolean isClosed(char curr) {
        if(curr == '{' || curr == '[' || curr == '(' || curr == '<') return false;
        return true;
    }

    public static void part2() throws FileNotFoundException {
        File input = new File("inputs/day10.txt");

        Scanner sc = new Scanner(input);
        ArrayList<String> inputs = new ArrayList<>();

        while(sc.hasNextLine()) {
            inputs.add(sc.nextLine());
        }

        List<char[]> filtered = Stream.of(inputs.toArray(new String[0]))
            .map(i -> i.toCharArray())
            .toList();
        sc.close();

        ArrayList<Long> incompleteScores = new ArrayList<>();

        for(int j = 0; j < filtered.size(); j++) {
            Stack<Character> ck = new Stack<>();
            long pts = 0;
            int counter = 0;

            while(!isClosed(filtered.get(j)[counter])) {
                ck.add(filtered.get(j)[counter]);
                counter++;
            }

            while(counter < filtered.get(j).length) {
                if(!ck.empty() && isOpposite(ck.peek(), filtered.get(j)[counter])) {
                    ck.pop();
                    counter++;
                } else {
                    if(!isClosed(filtered.get(j)[counter])) {
                        ck.add(filtered.get(j)[counter]);
                        //System.out.println("IF" + filtered.get(j)[counter]);
                        counter++;

                    } else { // INVALID CASE, SO WE CLEAR AND MOVE ON
                        ck.clear();
                        break;
                    }
                }
            }

            while(!ck.isEmpty()) {
                switch(ck.pop()){
                    case'(':
                        pts = pts*5 + 1;
                        break;
                    case'[':
                        pts = pts*5 + 2;
                        break;
                    case'{':
                        pts = pts*5 + 3;
                        break;
                    case'<':
                        pts = pts*5 + 4;
                        break;
                }
            }

            if(pts != 0) {
                incompleteScores.add(pts);
            }

            // for(int i = 0; i < filtered.get(j).length; i++) {
            //     if(!isClosed(filtered.get(j)[i])) { // part 1 of corrupted
            //         ck.add(filtered.get(j)[i]);
            //         //System.out.println("j");
            //     } else {
            //         if(!isOpposite(ck.pop(), filtered.get(j)[i])) {
            //             incompleteScores[j] = 0;
            //             break; // takes out of the char(b:a) loop
            //         } else { // is incomplete line, not corrupted
            //             switch(filtered.get(j)[i]) {
            //                 case')':
            //                     System.out.print(")");
            //                     incompleteScores[j] = incompleteScores[j]*5 + 1;
            //                     break;
            //                 case']':
            //                     System.out.print("]");
            //                     incompleteScores[j] = incompleteScores[j]*5 + 2;
            //                     break;
            //                 case'}':
            //                     System.out.print("}");
            //                     incompleteScores[j] = incompleteScores[j]*5 + 3;
            //                     break;
            //                 case'>':
            //                     System.out.print(">");
            //                     incompleteScores[j] = incompleteScores[j]*5 + 4;
            //                     break;
            //             }
            //         }
            //     }
            // }

        }

        Collections.sort(incompleteScores);
        System.out.println(incompleteScores.get(incompleteScores.size()/2));
    }
}