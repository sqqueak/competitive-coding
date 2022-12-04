import java.util.Scanner;

public class _2HanksHarvest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String cur = in.nextLine();
        char[] crops = cur.toCharArray();
        int rot = 0, zucc = 0, pot = 0, corn = 0;

        if(crops.length < 15) System.out.println("This year's harvest is bad!");
        else {
            for(char crop : crops) {
                switch(crop) {
                    case'R':
                        rot++;
                        break;
                    case'Z':
                        zucc++;
                        break;
                    case'P':
                        pot++;
                        break;
                    case'C':
                        corn++;
                        break;
                }
            }
            System.out.println(rot + " " + zucc + " " + pot + " " + corn);
            if(zucc < 5 || corn < 2 || pot < 4 || rot > 0.1*crops.length) System.out.println("This year's harvest is bad!");
            else System.out.println("This year's harvest is good!");
        }
    }
}