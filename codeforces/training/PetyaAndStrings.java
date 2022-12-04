import java.util.*;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String l1 = in.nextLine().toLowerCase();
        String l2 = in.nextLine().toLowerCase();

        int a = l1.compareTo(l2);
        if(a > 0) {
            System.out.println(1);
        } else if(a < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }

        in.close();
    }
}