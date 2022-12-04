
/*
ID: heyitssqueak
LANG: JAVA
TASK: flowers
*/
import java.io.*;
import java.util.StringTokenizer;

public class flowers {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numOfFlowers = Integer.parseInt(f.readLine());
        StringTokenizer petals = new StringTokenizer(f.readLine());
        int[] numOfPetals = new int[numOfFlowers];

        int perfectFlowers = 0;

        for(int i = 0; i < numOfPetals.length; i++) {
            numOfPetals[i] = Integer.parseInt(petals.nextToken());
        }

        for(int i = 0; i < numOfPetals.length; i++) { // counting i

            for(int j = i; j < numOfPetals.length; j++) { // counting j

                int flowersInPic = 0;

                if(j == i) {
                    perfectFlowers++;
                } else {
                    int jIndex = j;
                    int iIndex = i;

                    flowersInPic = jIndex - iIndex + 1;
                    int petalCounter = 0;

                    for(int counter = i; counter <= j; counter++) {
                        petalCounter += numOfPetals[counter];
                    }

                    double averagePetals = (double)petalCounter / (double)flowersInPic;
                    for(int counter = i; counter <= j; counter++) {
                        if((double)numOfPetals[counter] == averagePetals) {
                            perfectFlowers++;
                            // System.out.println(i + "  "+ j);
                            // System.out.println(petalCounter + " " + flowersInPic);
                            // System.out.println(averagePetals);
                            // System.out.println("-----");
                            //System.out.println(petalCounter);
                            break;
                        } 
                    }

                    // System.out.println(i + "  "+ j);
                    // System.out.println(petalCounter);

                }


            }


        }  
        
        System.out.println(perfectFlowers);

    }
}