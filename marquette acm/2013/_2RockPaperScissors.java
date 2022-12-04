import java.util.Scanner;

public class _2RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String game = in.nextLine();
        int gcount = 0;

        while(!game.equals("End")) {
            int regis = 0, david = 0;

            // individual games
            while(!game.equals("End")) {
                regis = 0; david = 0;
                
                switch(game) {
                    case"RS":
                        david++;
                    case"RP":
                        regis++;
                    case"SP":
                        david++;
                    case"PS":
                        regis++;
                    case"SR":
                        regis++;
                    case"PR":
                        david++;
                }
                
                game = in.nextLine();
            }
            gcount++;
            
            // Contest #1: Regis wins
            // Contest #2: Tie
            
            if(regis > david) System.out.println("Contest #" + gcount + ": Regis wins");
            else if(david > regis) System.out.println("Contest #" + gcount + ": David wins");
            else System.out.println("Contest #" + gcount + ": Tie");

            game = in.nextLine();
        }

        in.close();
    }
}