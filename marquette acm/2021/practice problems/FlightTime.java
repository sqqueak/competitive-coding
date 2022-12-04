import java.util.Scanner;

public class FlightTime {

	/*
	 * It is unnecessary to edit the "main" method of each problem's provided code
	 * skeleton. The main method is written for you in order to help you conform to
	 * input and output formatting requirements.
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();
		for (; cases > 0; cases--) {

			// User Input
			int dist = in.nextInt();
			int velo = in.nextInt();
			int depHr = in.nextInt();
			int depMin = in.nextInt();

			// Function Call
			int[] flight = totalFlightTime(dist, velo, depHr, depMin);

			// Terminal Output
			System.out.printf("%d:%02d\n", flight[0], flight[1]);
		}

		in.close();

	}

	/**
	 * TODO: Complete the following method that calculates the arrival time of a
	 * flight based on the given parameters:
	 * 
	 * Note: You do not need to account for time of day signifiers (AM or PM). Note:
	 * You do not need to account for time change between time zones.
	 * 
	 * @param distance     --> the distance in miles of the flight
	 * @param velocity     --> how fast the plane is going in mph
	 * @param departureHr  --> the hour in which the plane departs
	 * @param departureMin --> the minute in which the plane departs
	 * @return new int[] {arrivalHr, arrivalMin} --> an array with arrivalHr at
	 *         index 0 and arrivalMin at index 1
	 */
	public static int[] totalFlightTime(int distance, int velocity, int departureHr, int departureMin) {
		double min = ((double) distance / (double) velocity) * 60;
		int arrivalHr = (departureHr + (int) Math.floor((departureMin + min) / 60)) % 12;
		arrivalHr = arrivalHr == 0 ? 12 : arrivalHr;
		int arrivalMin = (departureMin + (int) (min)) % 60;
		return new int[] { arrivalHr, arrivalMin };
	}
}
