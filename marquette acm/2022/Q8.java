import java.io.*;
import java.util.*;

public class Q8 {

	/**
    * TODO: Generate an n*n square where the rows, columns, and diagonal sum to the same number:
    * 
    * Notes: 
	* 1. n will always be an odd integer
    * 2. Every number in the square can only be used once
    * 3. The numbers in the square should be from 1 to n*n
    * 
    * @param n --> the dimensions of the square
    *
    * @return new int[][] --> a 2D integer array containing the square
    */
	public static int[][] generateSquare(int n)
	{
        boolean[][] addOne = new boolean[n][n];

        for(int row = 0; row < n; row++) {
            for(int column = 0; column < n; column++) {
                addOne[row][column] = false;
            }
        }
        int[][] perfectSquare = new int[n][n];
        // double sumPerRow = ((n * n) * (n * n + 1) / 2) / n;

         int startingCorner = (((n * n) / 2) + 1) - (n / 2);

        for(int i = 0; i < n; i++) {
             perfectSquare[n - 1 - i][i] = startingCorner + i;
         }

   

         perfectSquare[n / 2][n - 1] = 1;

         for(int i = n - 2; i >= 0; i--) {
             perfectSquare[n / 2][i] = perfectSquare[n/2][i + 1] + n + 1;
         }
        
        for(int row = 0; row < n / 2; row++) {
                int columnIndex = (n - 2 * row) - 1;

                addOne[row][columnIndex - 1] = true;
            
        }

        for(int row = n - 1; row > n / 2; row--) {
            int columnIndex = 2 * ((n - 1) - row);

            addOne[row][columnIndex + 1] = true;
            
        }

        
        
        for(int row = 0; row < n; row++) {
            if(row == n/2) {
                //do nothing
            } else {
                int solvedPosition = n - 1 - row;
                for(int position = solvedPosition - 1; position >= 0; position--) {
                    if(addOne[row][position]) {
                        perfectSquare[row][position] = perfectSquare[row][position + 1] + 1;
                    } else {
                        perfectSquare[row][position] = (perfectSquare[row][position + 1] + n + 1) % (n * n);
                    }
                }

                for(int position = solvedPosition + 1; position < n ; position++) {
                    int target = position - 1;
                    
                    if(addOne[row][position]) {
                        System.out.println("in add");
                        perfectSquare[row][position] = perfectSquare[row][target] - 1;
                    } else {
                        perfectSquare[row][position] = (perfectSquare[row][target] - n - 1) % (n * n);
                        if(perfectSquare[row][position] < 0) {
                            perfectSquare[row][position] = n * n +  perfectSquare[row][position];
                        }
                    }
                }
            }

            
        }


        
        
		return perfectSquare;
	}

	/*
    * It is unnecessary to edit the "main" method of each problem's provided code
    * skeleton. The main method is written for you in order to help you conform to
    * input and output formatting requirements.
    */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (; cases > 0; cases--) {
			// User Input
			int n = Integer.parseInt(in.nextLine());
			
			// Function Call
			int magicSquare[][] = generateSquare(n);

			// Terminal Output
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(magicSquare[i][j] + " ");
				System.out.println();
			}
		}

		in.close();
	}
}