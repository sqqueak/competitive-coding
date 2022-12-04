import java.util.Scanner;
import java.util.ArrayList;

public class Q2 {

    /**
    * TODO: Find the numbers of length n that sum to x given the following parameters:
    *
    * @param length --> the number of digits
    * @param sun --> the number the digits should sum to
    *
    * @return new ArrayList<Integer> --> an ArrayList<Integer> containing <values or variables to be returned>
    *
    * Note: Make sure your list is ordered from least to greatest
    */
    public static ArrayList<Integer> numberSum(int length, int sum) {
        ArrayList<Integer> matching = new ArrayList<Integer>();
        for(int currentNum = (int) Math.pow(10, length - 1); currentNum < Math.pow(10, length); currentNum++) {
            int digitTotal = 0;
            for(int ii = 0; ii <= length; ii++) {
                int currentDigit = (int) ((currentNum % Math.pow(10, ii + 1)) / Math.pow(10, ii));
                digitTotal += currentDigit;
            }


            if(digitTotal == sum) {
                matching.add(currentNum);
            }
        }
        return matching;
    }

    /*
    * It is unnecessary to edit the "main" method of each problem's provided code
    * skeleton. The main method is written for you in order to help you conform to
    * input and output formatting requirements.
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (; cases > 0; cases--) {

            // User Input
            String[] inp = in.nextLine().split(",");

            // Function Call
            ArrayList<Integer> numbers = numberSum(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));

            // Terminal Output
            String output = "";
            for (Integer number : numbers) {
                output = output + number + " ";
            }
            System.out.println(output);
        }

        in.close();

    }
}