import java.util.Scanner;

public class Q1 {

	/**
    * TODO: Write a program that converts fahrenheit to celsius given the following parameters:
    * 
    * @param fahrenheit --> the temperature in fahrenheit
    *
    * @return new double --> a double containing the temperature converted to celsius
    * 
    * Note: The formula for conversion is (5 * (fahrenheit - 32)) / 9.
    * Note: When the number is printed, we round it automatically to the nearest integer to account for round off errors.
    */
    public static double convertTemperature(double fahrenheit) {
        return (((fahrenheit - 32.0) * 5.0)/9.0);
    }

	/*
    * It is unnecessary to edit the "main" method of each problem's provided code
    * skeleton. The main method is written for you in order to help you conform to
    * input and output formatting requirements.
    */
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt(in.nextLine());
        for (; cases > 0; cases--) {

            // User Input
			double fahrenheit = Double.parseDouble(in.nextLine());

            // Function Call
            double celsius = convertTemperature(fahrenheit);

            // Terminal Output
            // Round to nearest integer
            System.out.println(Math.round(celsius));
        }

        in.close();
	}
}