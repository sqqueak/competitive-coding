// Handy Haversacks

package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day7 {
    public static void main(String[] args) {
        part1();
    }

    public static void part1() {
        ArrayList<String> inputs = new ArrayList<>();

        File input = new File("day7\\input.txt");
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                inputs.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find your input file.");
        }

        String[] outsideBag = new String[inputs.size()];
        String[] insideBag = new String[inputs.size()]; 

        for(int i = 0; i < inputs.size(); i++) {
            outsideBag[i] = inputs.get(i).split(" contain ")[0];
            insideBag[i] = inputs.get(i).split(" contain ")[1];
        }

        // adding direct bags
        ArrayList<String> viableBags = new ArrayList<>();
        for(int i = 0; i < inputs.size(); i++) {
            if(insideBag[i].contains("shiny gold")) {
                viableBags.add(outsideBag[i]);
                //inputs.remove(i);
            }
        }

        // interating through and adding indirect bags until there are no more
        int counter = 0;
        do {
            String currBag = viableBags.get(counter);
            String currType = getType(currBag);
            for(int i = 0; i < inputs.size(); i++) {
                if(insideBag[i].contains(currType) && viableBags.contains(outsideBag[i]) == false) {
                    viableBags.add(outsideBag[i]);
                }
            }
            counter++;
        } while(counter < viableBags.size());

        System.out.println(viableBags.size());

    }

    public static String getType(String bag) {
        String[] words = bag.split(" ");
        return (words[0] + " " + words[1]);
    }
}