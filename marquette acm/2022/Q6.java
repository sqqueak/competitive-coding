import java.util.Scanner;

public class Q6 {

	/**
    * TODO: Find the total number of ways that Johnny can cross N lines by crossing one, two, or three lines each step:
    * 
    * @param n --> the number of lines
    *
    * @return new integer --> an integer representing the number of ways Johnny can take by stepping over 1, 2, or 3 lines.
    */
	public static int steps(int n)
	{
		int total = 0;
		if(n == 0) return 1;
		if(n-1 >= 0) {total += steps(n-1);}
		if(n-2 >= 0) {total += steps(n-2);}
		if(n-3 >= 0) {total += steps(n-3);}
		return total;
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
            int stairs = Integer.parseInt(in.nextLine());

            // Function Call
            int number_of_ways = steps(stairs);

            // Terminal Output
            System.out.println(number_of_ways);
        }

        in.close();
    }
}