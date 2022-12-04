package training.gift1;

/*
ID: heyitssqueak
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.StringTokenizer;

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int numOfPeople = Integer.parseInt(f.readLine());
        String[] people = new String[numOfPeople];
        int[] netMoney = new int[numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            people[i] = f.readLine();
        }

        String giver;

        while ((giver = f.readLine()) != null) {
            StringTokenizer moneyAndSplit = new StringTokenizer(f.readLine());

            int money = Integer.parseInt(moneyAndSplit.nextToken());
            int split = Integer.parseInt(moneyAndSplit.nextToken());
            int giverIndex = 0;

            for (int i = 0; i < people.length; i++) {
                if (giver.equals(people[i])) {
                    giverIndex = i;
                    break;
                }
            }

            if (split == 0) {

            } else if(money == 0) {
                for(int i = 0; i < split; i++) {
                    f.readLine();
                }
            } else {
                netMoney[giverIndex] = (netMoney[giverIndex] - money) + (money % split);

                money -= money % split;
                int share = money / split;

                for(int i = 0; i < split; i++) {

                    String receiver = f.readLine();
                    for(int j = 0; j < people.length; j++) {
                        if(receiver.equals(people[j])) {
                            netMoney[j] += share;
                            break;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < people.length; i++) {
            out.println(people[i] + " " + netMoney[i]);
        }

        out.close();
        f.close();
    }
}