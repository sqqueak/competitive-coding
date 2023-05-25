import java.util.Scanner;

public class beads {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        sc.close();

        String necklace = input+input;

        int currColorCount = 1;
        int prevColorCount = 0;

        char currStreak = '0';

        int maxCombinedCount = 0;

        for(int index = 1; index < necklace.toCharArray().length; index++) {
            char prevBead = necklace.charAt(index-1);
            char currBead = necklace.charAt(index);

            System.out.print(prevBead + ":" + currBead);

            if((prevBead == 'b' && currBead == 'r' || prevBead == 'r' && currBead == 'b')) {
                currColorCount++;
                System.out.println(" BREAK " + currColorCount);
                currColorCount = 1;
            } else {
                currColorCount++;
                System.out.println(" JOINED " + currColorCount);
            }

            if(currColorCount + prevColorCount > maxCombinedCount) {
                maxCombinedCount = currColorCount + prevColorCount;
            }
        }

        System.out.println(maxCombinedCount);
    }
}