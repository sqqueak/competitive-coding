package training.ride;

/*
ID: heyitssqueak
LANG: JAVA
TASK: ride
*/
import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String ufo = f.readLine();
        String group = f.readLine();

        int ufoNum = 1;
        int groupNum = 1;

        for (int i = 0; i < ufo.toCharArray().length; i++) {
            ufoNum *= (int)ufo.toCharArray()[i] - 64;
        }

        for (int i = 0; i < group.toCharArray().length; i++) {
            groupNum *= (int)group.toCharArray()[i] - 64;
        }

        if (ufoNum % 47 == groupNum % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();
        f.close();
    }
}