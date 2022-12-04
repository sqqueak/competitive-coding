import java.util.Scanner;

public class Q3 {

	/**
	 * TODO: Implement the leetspeak() method given the following parameters:
	 * 
	 * Notes: If a word contains 3 or more distinct original characters then it should,
	 * not be converted to Jake's version of leetspeak.
	 * 
	 * Additional Notes: It can be assumed that the input will be be all uppercase letters. It
	 * can be assumed that the input will not be empty.
	 * 
	 * @param sentence --> Jake's original message
	 *
	 * @return new String --> a String containing converted leetspeak
	 */
	public static String leetspeak(String sentence) {
		String output = "";
		// Implement code below
        String[] letter = {"A", "B", "E", "G", "I", "O", "S", "T", "Z"};
        String[] replace = {"4", "8", "3", "6", "1", "0", "5", "7", "2"};
        String[] words = sentence.split(" ");
        for (String s: words) {
            String temp = s;
            String unique = "";
            for(int i = 0; i < temp.length(); i++){
                String l = temp.substring(i, i+1);
                for(int j = 0; j < letter.length; j++){
                    if(l.equals(letter[j])){
                        unique += l;
                        temp = temp.replaceAll(l, replace[j]);
                    }
                }
            }
            if(unique.length() > 2) {output += s + " ";}
            else {output += temp + " ";}
        }
		output = output.trim();
		return output;
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
			String input = in.nextLine();

			// Function Call
			String leetSpoken = leetspeak(input);

			// Terminal Output
			System.out.println(leetSpoken);
		}
		in.close();
	}
}