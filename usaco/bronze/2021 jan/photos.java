
/*
ID: heyitssqueak
LANG: JAVA
TASK: photos
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class photos {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numOfCows = Integer.parseInt(f.readLine());
        StringTokenizer stringCowID = new StringTokenizer(f.readLine());

        int[] cowIDs = new int[numOfCows];

        for(int i = 0; i < numOfCows; i++) {
            cowIDs[i] = Integer.parseInt(stringCowID.nextToken());
        }

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int num : cowIDs) {
            if (num % 2 == 0) {
                even.add(num);
                //System.out.println(num);
            } else {
                odd.add(num);
                //System.out.println(num);
            }
        }

        int evens = even.size();
        int odds = odd.size();

        if(evens > odds) {
            System.out.println((odds*2) + 1);
        } else if(odds > evens) {
            int diff = odds - evens;

            //System.out.println(diff);
            if(diff % 3 == 0) {
                System.out.println(evens*2 + (int)((double) diff * ((double)2 / (double) 3)));
            } else if(diff % 3 == 2) {
                System.out.println(evens*2 +  (int)((double) (diff+1) * ((double)2 / (double) 3)) - 1);
            } else if(diff % 3 == 1) {
                if(diff == 1) {
                    System.out.println(evens*2 - 1);
                } else {
                    System.out.println(evens*2 +  (int)((double) (diff-1) * ((double)2 / (double) 3)) - 1);
                }
            }
        } else {
            System.out.println(evens*2);
        }

        // int groups = 0;
        // int counter = 0;

        // if(odd.size() == 0) {
        //     System.out.println(0);
        // } else if(even.size() == 0) {
        //     System.out.println(3);
        // } else {
        //     boolean keepGoing = true;

        //     while(keepGoing) {
        //         if(groups % 2 == 0) {
        //             if(even.isEmpty() == false) {
        //                 even.remove(0);
        //                 groups++;
        //             } else if(odd.size() >= 2) {
        //                 odd.remove(0);
        //                 odd.remove(0);
        //                 groups++;
        //             } else {
        //                 keepGoing = false;
        //             }
        //         } else {
        //             if(odd.isEmpty() == false) {
        //                 odd.remove(0);
        //                 groups++;
        //             // } else if(even.size() >= 1 && odd.size() >= 1) {
        //             //     even.remove(0);
        //             //     odd.remove(0);
        //             //     groups++;
        //             } else {
        //                 keepGoing = false;
        //             }
        //         }

        //         System.out.println(even.size() +  " " + odd.size());
        //     }

        //     System.out.println(groups);
        // }



        f.close();
    }
}
