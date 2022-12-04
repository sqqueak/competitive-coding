import java.util.Arrays;
import java.util.Scanner;

public class ToggleGrid {

	static int[][] grid = new int[100][100];

	/**
	 * TODO: Write a function that processes an instruction
	 * 
	 * @param code   --> 0: Turn Off / 1: Turn On / 2: Toggle
	 * @param startX --> The starting x-coordinate of the instruction.
	 * @param startY --> The starting y-coordinate of the instruction.
	 * @param width  --> The number of columns to process on.
	 * @param height --> The number of rows to process on.
	 */
	public static void execute(int code, int startX, int startY, int width, int height) {
		for (int i = startX; i < startX + width; i++) {
			for (int j = startY; j < startY + height; j++) {
				if (code == 0) {
					grid[i][j] = 0;
				} else if (code == 1) {
					grid[i][j] = 1;
				} else {
					grid[i][j] = grid[i][j] == 1 ? 0 : 1;
				}
			}
		}

	}

	public static int count() {
		int lights_on = 0;

		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid.length; y++)
				if (grid[y][x] == 1)
					lights_on++;

		return lights_on;
	}

	/*
	 * It is unnecessary to edit the "main" method of each problem's provided code
	 * skeleton. The main method is written for you in order to help you conform to
	 * input and output formatting requirements.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();
		for (; cases > 0; cases--) {
			grid = new int[100][100];
			int numInstructions = in.nextInt();
			for (; numInstructions > 0; numInstructions--) {
				String str = in.next();
				String[] s = str.split(",");

				int code = Integer.parseInt(s[0]);
				int startX = Integer.parseInt(s[1]);
				int startY = Integer.parseInt(s[2]);
				int width = Integer.parseInt(s[3]);
				int height = Integer.parseInt(s[4]);

				execute(code, startX, startY, width, height);
			}
			System.out.println(count());
		}
		in.close();
	}
}
