package beads;

/*
ID: heyitssqueak
LANG: JAVA
TASK: beads
*/
import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int numOfBeads = Integer.parseInt(f.readLine());
        char[] beads = f.readLine().toCharArray();


        // have length a and length b
        // have total length of a and b (largest num of beads)
        // have index of largest consec a and b

        int maximumLength = 0;
        int lengthA = 0;
        int lengthB = 0;
        int index = 0; // index inbetween
        
        int indexCounter = 0;

        int beadCounter = 1;
        while(indexCounter < numOfBeads) {

            
            
        }

        

        System.out.println(index);
        System.out.println(maximumLength);


        out.close();
        f.close();
    }
}