import java.lang.Math;
import java.util.Scanner;

public class ColoringGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for(int i = 0; i < n; i += 1) {
            double c = Integer.parseInt(in.nextLine());
            System.out.println("Case #" + (int)(i+1) + ": " + (int)(Math.ceil(c/5)));
        }

        in.close();
    }
}