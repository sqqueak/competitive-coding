import java.util.Scanner;

public class Q5 {
    
	/**
    * TODO: Return a string of the spiral traverse given the following parameters:
    * 
    * @param array --> a 2D integer array contains the entires to preform the sprial reverse on
    *
    * @return new String --> a string containing the sprial traverse of the interger array
    */
    public static String spiralTraverse(int[][] array) {
		String fin = "";

		int buffer = 0;
		int x = -1;
		int y = 0;
		int area = array.length * array[0].length;
		int finarea = 0;

		while (finarea != area) {
			// Right
			for (int c = 0; c < array[0].length - buffer; c++) {
				x++;
				fin += Integer.toString(array[y][x]);
				finarea++;
			}
			if (area == finarea)
				return fin;
			buffer++;
			// Down
			for (int r = 0; r < array.length - buffer; r++) {
				y++;
				fin += Integer.toString(array[y][x]);
				finarea++;
			}
			// Left
			for (int c = 0; c < array[0].length - buffer; c++) {
				x--;
				fin += Integer.toString(array[y][x]);
				finarea++;
			}
			if (area == finarea)
				return fin;
			buffer++;
			// Up
			for (int r = 0; r < array.length - buffer; r++) {
				y--;
				fin += Integer.toString(array[y][x]);
				finarea++;
			}
		}

		return fin;
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
			int rows = Integer.parseInt(inp[0]);
			int cols = Integer.parseInt(inp[1]);
			int[][] spiral = new int[rows][cols];

			for(int i = 0; i < rows; i++) {
				String[] entries = in.nextLine().split(",");

				for(int j = 0; j < cols; j++) {
					spiral[i][j] = Integer.parseInt(entries[j]);
				}
			}

			// Function Call
			String spiral_order = spiralTraverse(spiral);

			// Terminal Output
			System.out.println(spiral_order);
	}

	in.close();

}
}
