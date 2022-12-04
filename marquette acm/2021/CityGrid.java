import java.util.Scanner;

public class CityGrid {

    /*
     * TODO: Determine if a city grid is valid given the following parameters:
     *
     * Parameters: grid --> A 10x10 two-dimensional int array filled with integer
     * values: 0, 1, 2, or 3.
     * 
     * Returns: a boolean: True if the city grid is valid. Otherwise, false.
     * 
     * Note: The grid will only be filled with the integers 0, 1, 2, or 3. The size
     * of the grid will always be 10 by 10.
     */
    public static boolean isValidCityGrid(int[][] grid) {

        for (int i = 0; i < 4; i++) { // loops thru each situation once
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    if (grid[row][col] == i) {

                    }
                }
            }
        }

        return false;
    }

    // It is unnecessary to edit the "main" function of each problem's provided code
    // skeleton.
    // The main function is written for you in order to help you conform to input
    // and output formatting requirements.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int tests = Integer.parseInt(in.nextLine()); tests > 0; tests--) {
            int[][] grid = new int[10][10];

            for (int row = 0; row < 10; row++) {
                String str = in.next();
                String[] s = str.split(",");

                for (int col = 0; col < 10; col++)
                    grid[row][col] = Integer.parseInt(s[col]);
            }

            boolean result = isValidCityGrid(grid);

            if (result)
                System.out.println("True");
            else
                System.out.println("False");
        }

        in.close();
    }
}