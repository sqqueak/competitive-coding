import java.util.Scanner;
import java.util.regex.Pattern;
public class Q4 {

    /**
    * TODO: Determine if the string satisfying the pattern given the following parameters:
    * 
    * Note: All patterns will contain only lowercase english letters, *, and .
    * The * matches zero or more preceding elements.  The . matches any single character
    * 
    * @param string_val --> the string to see if the pattern matches
    * @param ptrn --> the pattern
    *
    * @return new boolean --> a boolean returning true if the string satisfies the pattern.  Return false if otherwise
    */
    public static boolean isMatch(String string_val, String ptrn) {
        // Pattern p = Pattern.compile(ptrn);
        // Matcher m = p.matcher(string_val);
        // return m.matches();

        return Pattern.matches(ptrn, string_val);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());
        for (; cases > 0; cases--) {

            // User Input
            String string = in.nextLine();
            String pattern = in.nextLine();

            // Function Call
            boolean doesMatch = isMatch(string, pattern);

            // Terminal Output
            System.out.println(doesMatch);
        }

        in.close();
    }
}
