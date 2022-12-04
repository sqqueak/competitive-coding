import java.util.Scanner;

public class Q7 {

    /**
    * TODO: Generate a balanced triangle given the following parameters:
    * 
    * Note: n > 2
    * 
    * @param n --> the number of rows to generate in the triangle
    *
    * @return new 2D array of integers --> a 2D array of integers containing the values of the balanced triangle
    */
    public static int[][] balanced_triangle(int n) {
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int ii = 0; ii < n; ii++) {
                triangle[i][ii] = 0;
            }
        }
        triangle[0][0] = 1;

        for(int row = 1; row < n; row++) {
            for(int column = 0; column < n; column++) {
                if(column == 0)  {
                    triangle[row][column] = triangle[row - 1][column];
                } else {
                    triangle[row][column] = triangle[row - 1][column] + triangle[row - 1][column - 1];
                }

                
            }
        }



        return triangle;
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
            int rows = Integer.parseInt(in.nextLine());

            // Function Call
            int[][] arr = balanced_triangle(rows);

            // Terminal Output
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < rows; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
        }

        in.close();

    }

}