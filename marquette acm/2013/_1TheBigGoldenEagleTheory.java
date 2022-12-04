import java.util.Scanner;

public class _1TheBigGoldenEagleTheory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String c = in.nextLine();
        String[] carr= c.split(" ");
        // will take 0 1 . . 4 5
        
        String coords = in.nextLine();
        while(!coords.isEmpty()) {
            String[] co = coords.split(" ");
            if(Integer.parseInt(co[0]) < Integer.parseInt(carr[0]) || Integer.parseInt(co[1]) < Integer.parseInt(carr[1])
            || Integer.parseInt(co[0]) > Integer.parseInt(carr[4]) || Integer.parseInt(co[1]) > Integer.parseInt(carr[5])) System.out.println("Miss");
            else System.out.println("Hit");

            coords = in.nextLine();
        }

        in.close();
    }
}