/*
ID: heyitssqueak
LANG: JAVA
TASK: stalls
*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class stalls2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numOfCows = Integer.parseInt(f.readLine());
        StringTokenizer stringCowHeights = new StringTokenizer(f.readLine());
        StringTokenizer stringStallHeights = new StringTokenizer(f.readLine());

        int[] cowHeights = new int[numOfCows];
        int[] stallHeights = new int[numOfCows];
        
        int count = 0;
        for(int height : cowHeights) {
            height = Integer.parseInt(stringCowHeights.nextToken());
            cowHeights[count] = height;
            //System.out.println(height);
            count++;
        }

        count = 0;
        for(int height : stallHeights) {
            height = Integer.parseInt(stringStallHeights.nextToken());
            stallHeights[count] = height;
            //System.out.println(height);
            count++;
        }

        int[] sortedCows = new int[numOfCows];
        int[] sortedStalls = new int[numOfCows];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for(int height : cowHeights) {
        //     System.out.println("COWS!!");
        //    System.out.println(height);
        // }

        for(int cow : cowHeights) {
            pq.add(cow);
        }

        int counter = 0;
        while(!pq.isEmpty()) {
            sortedCows[counter] = (pq.remove());
            counter++;
        }

        for(int stall : stallHeights) {
            pq.add(stall);
        }

        counter = 0;
        while(!pq.isEmpty()) {
            sortedStalls[counter] = (pq.remove());
            counter++;
        }

        // for(int stall : sortedStalls) {
        //     System.out.println(stall);
        // }
        
        long total = 1;
        int notFit = 0;

        int[] fittedHeights = new int[numOfCows];

        for(int i = 0; i < numOfCows; i++) {
            int cow = sortedCows[i];
           System.out.println("COW:" + cow);
            for(int j = numOfCows-1; j >= 0; j--) {
                System.out.println("STALL:" + sortedStalls[j]);
                if(sortedStalls[j] < cow) {
                    fittedHeights[i]++;
                }
            }
        }

        for(int stall : fittedHeights) {
            System.out.println(stall);
        }

        long fittedTotal = 1;

        for(int i = numOfCows-1; i >= 0; i--) {
            total *= cowHeights[i] - fittedHeights[i];
        }


        System.out.println(total);

    }
}