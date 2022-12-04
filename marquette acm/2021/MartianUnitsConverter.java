// Do NOT include a package statement at the top of your solution.

import java.util.Scanner;

public class MartianUnitsConverter {

    /**
     * TODO: Complete the following method that converts a temperature in Martian
     * Units to Global Overtemps based on the given parameters:
     * 
     * @param mu --> the input temperature in Martian Units
     * @return result --> the temperature converted to Global Overtemps
     */

    public static double converter(int mu) {
        double result = ((double)mu * 0.75) + 34;
        return result;
    }

    /*
     * It is unnecessary to edit the "main" method of each problem's provided code
     * skeleton. The main method is written for you in order to help you conform to
     * input and output formatting requirements.
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for (int iCase = 0; iCase < numCases; iCase++) {
            int martianUnits = kb.nextInt();
            double globalOvertemps = converter(martianUnits);
            System.out.println(globalOvertemps);
        }
        kb.close();
    }
}