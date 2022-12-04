import java.util.Scanner;

public class TaylorSeries {

	/*
	 * It is unnecessary to edit the "main" method of each problem's provided code
	 * skeleton. The main method is written for you in order to help you conform to
	 * input and output formatting requirements.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (; cases > 0; cases--) {
			double a = in.nextDouble();
			System.out.printf("%.3f %.3f\n", sin(a), cos(a));
		}
		in.close();
	}

	/**
	 * TODO: Complete the following method which calculates the cosine given an
	 * angle in degrees
	 * 
	 * @param x --> the angle given in degrees
	 * @return result --> the cosine given in radians
	 */
	public static double cos(double x) {
		x *= (Math.PI / 180);
		double sum = 0;

		for (int n = 0; n < 20; n++) {
			sum += Math.pow(-1, n) * (Math.pow(x, 2 * n) / factorial(2 * n));
		}

		return sum;
	}

	/**
	 * TODO: Complete the following method which calculates the sine given an angle
	 * in degrees
	 * 
	 * @param x --> the angle given in degrees
	 * @return result --> the sine given in radians
	 */
	public static double sin(double x) {
		x *= (Math.PI / 180);
		double sum = 0;

		for (int n = 1; n < 20; n++) {
			sum += Math.pow(-1, n - 1) * (Math.pow(x, 2 * n - 1) / factorial(2 * n - 1));
		}

		return sum;
	}

	/**
	 * 
	 * Note: Use this factorial method when developing your code
	 * 
	 * @param x --> the value that is used to calculate the factorial
	 * @return result --> the result of x!
	 */
	public static double factorial(int x) {
		double result = 1;
		if (x == 0)
			result = 1;
		else {
			for (int n = 1; n <= x; n++) {
				result *= n;
			}
		}
		return result;
	}
}
