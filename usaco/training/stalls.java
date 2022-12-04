/*
ID: heyitssqueak
LANG: JAVA
TASK: stalls
*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class stalls {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numOfCows = Integer.parseInt(f.readLine());
        StringTokenizer stringCowHeights = new StringTokenizer(f.readLine());
        StringTokenizer stringStallHeights = new StringTokenizer(f.readLine());

        String cowHeightsFINAL = "";
        String stallHeightsString2 = "";
        char[] stallHeights = new char[numOfCows];

        for(int i = 0; i < numOfCows; i++) {
            cowHeightsFINAL += stringCowHeights.nextToken();
        }

        for(int i = 0; i < numOfCows; i++) {
            stallHeightsString2 += stringStallHeights.nextToken();
            //System.out.println(stallHeightsString2);
        }

        stallHeights = stallHeightsString2.toCharArray();

        for(int height : stallHeights) {
            height -= 48;
        }

        ArrayList<String> permutations = new ArrayList<>();

        permutation("", cowHeightsFINAL, permutations);
        int numOfPerms = 0;

        //System.out.println(permutations.size());

        for(String perm : permutations) {
            char[] cowHeights = perm.toCharArray();
            //System.out.println("STRING: " + perm);

            boolean doesPermWork = true;


            for(int i = 0; i < cowHeights.length; i++) {
                if(cowHeights[i] <= stallHeights[i]) {

                } else {
                    doesPermWork = false;
                    //System.out.println(cowHeights[i] + " - " + stallHeights[i]);
                }
            }

            if(doesPermWork) {
        
                // for(char height : cowHeights) {
                //     System.out.print(height);
                // }
                // System.out.println();

                numOfPerms++;
            }
        }

        System.out.println(numOfPerms);

        f.close();
    }

    public static void permutation(String comb, String str, ArrayList<String> list) {
        int wordLength = str.length();

        if(wordLength == 0) {
            list.add(comb);
        } else {
            for(int i = 0; i < wordLength; i++) {
                permutation(comb + str.charAt(i), str.substring(0, i) + str.substring(i+1, wordLength), list);
            }
        }
    }
}