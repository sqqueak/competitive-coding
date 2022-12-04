/*
ID: heyitssqueak
LANG: JAVA
TASK: socdis1
*/
import java.io.*;

public class socdis1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("socdis1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdis1.out")));

        int numOfCows = Integer.parseInt(f.readLine());
        char[] stalls = f.readLine().toCharArray();

        for(int i = 1; i < stalls.length-1; i++) {
            if(stalls[i] == '0') {
                if(stalls[i-1] == '1' || stalls[i+1] == '1') {
                    stalls[i] = 'X';
                }
            }
        }


        out.close();
        f.close();
    }
}