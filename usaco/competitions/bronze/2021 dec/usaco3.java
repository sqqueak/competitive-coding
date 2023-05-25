import java.util.ArrayList;
import java.util.Scanner;

public class usaco3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < size; i++) {
            String[] dimenK = sc.nextLine().split(" ");
            int N = Integer.parseInt(dimenK[0]);
            int K = Integer.parseInt(dimenK[1]);


            char[][] map = new char[N][N];
            for(int j = 0; j < N; j++) {
                map[j] = sc.nextLine().toCharArray();
            }

            boolean noHaybales = true;
            boolean oneBale = false;
            int[] oneHaybale = new int[2];

            for(int n = 0; n < N; n++) { // checking special conditions
                for(int m = 0; m < N; m++) {
                    if(noHaybales && map[n][m] == 'H') {
                        noHaybales = false;
                        oneHaybale = new int[] {n, m};
                        oneBale = true;
                    } else if(oneBale && map[n][m] == 'H') {
                        oneHaybale = null;
                        oneBale = false;
                        break;
                    }
                }
            }

            if(map[1][0] == 'H' && map[0][1] == 'H' || map[N-2][N-1] == 'H' && map[N-1][N-2] == 'H') {
                System.out.println(0);
                break;
            } // also checking special cases

            if(noHaybales) { // no bales covered
                switch(K) {
                    case(1):
                        System.out.println(2);
                        break;
                    case(2):
                        System.out.println(2*(N-2) + 2);
                        break;
                    case(3):
                        double t = 2*Math.pow(N,2) -(8*N) +8 + (2*(N-2) + 2);
                        System.out.println((int) t);
                        break;
                }
            }

            int possiblePaths = (int)(2*Math.pow(N,2) -(8*N) +8 + (2*(N-2) + 2));

            int[][] timesUsed = new int[N][N]; // this is number of times each square used

            // middle cells
            for(int n = 1; n < N-1; n++) {
                for(int m = 1; m < N-1; m++) {
                    timesUsed[n][m] = (2*(N-1));
                }
            }
            // edges
            for(int n = 1; n < N; n++) { 
                timesUsed[0][n] = ((N-1)-n)*(N-1)+1;
                timesUsed[n][0] = ((N-1)-n)*(N-1)+1;
                timesUsed[N-1][n] = (n)*(N-1)+1;
                timesUsed[n][N-1] = (n)*(N-1)+1;
            }
            
            // corners
            timesUsed[0][0] = possiblePaths;
            timesUsed[N-1][N-1] = possiblePaths;

            // for(int n = 0; n < N; n++) {
            //     for(int m = 0; m < N; m++) {
            //         System.out.print(timesUsed[n][m] + " ");
            //     }System.out.println();
            // }

            if(oneBale) {
                System.out.println(possiblePaths - timesUsed[oneHaybale[0]][oneHaybale[1]]);
            }


            // if(oneBale) { 
            //     switch(K) {
            //         case(3):
            //             possiblePaths += (int)(2*Math.pow(N,2) -(8*N) +8);
            //             int threek = (int)(2*Math.pow(N,2) -(8*N) +8);
            //             if(oneHaybale[0] != 0 && oneHaybale[1] != 0) { // middle bale
            //                 possiblePaths -= (int)(threek / 4);
            //             } else { // edge bale

            //             }

            //         case(2):
            //             possiblePaths += (2*(N-2));
            //             int twok = 2*(N-2);
            //             if(oneHaybale[0] != 0 && oneHaybale[1] != 0) { // middle bale
            //                 possiblePaths -= (int)(twok / 4);
            //             } else { // edge bale

            //             }

            //         case(1):
            //             possiblePaths += 2;
            //             if(oneHaybale[0] == 0 || oneHaybale[1] == 0) {
            //                 System.out.println(possiblePaths-1);
            //             } else {
            //                 System.out.println(possiblePaths);
            //             }
            //     }


                // switch(K) {
                //     case(1):
                //         if(oneHaybale[0] == 0 || oneHaybale[1] == 0) {
                //             System.out.println(1);
                //         } else {
                //             System.out.println(2);
                //         }

                //         break;

                //     case(2):
                //         possiblePaths = 2*(N-2) + 2;
                //         if(oneHaybale[0] == 0 || oneHaybale[1] == 0) { // edge bale
                            



                //         } else { // mid bale

                //         }



                //         break;
                //     case(3):
                //         possiblePaths = (int)(2*Math.pow(N,2) -(8*N) +8 + (2*(N-2) + 2));
                //         if(oneHaybale[0] == 0 || oneHaybale[1] == 0) {
                //             System.out.print(possiblePaths-1);
                //         } else {

                //         }


                //         break;
                // }


            //}
            

            // we know parsed data works
            // for(int n = 0; n < Integer.parseInt(dimenK[0]); n++) {
            //     for(int m = 0; m < Integer.parseInt(dimenK[0]); m++) {
            //         System.out.print(map[n][m]);
            //     }
            //     System.out.println();
            // }

            // int possiblePaths = 0;

            // if(K == 1) {
            //     possiblePaths += 2;
            //     // only two paths, all right > all down OR all down > all right
            //     // checking for if any of those cells have H

            //     for(int col = 0; col < N; col++) { // all right > all down
            //         boolean br = false;
            //         if(map[0][col] == 'H') {
            //             possiblePaths--;
            //             break;
            //         } else {
            //             for(int row = 0; row < N; row++) {
            //                 if(map[row][N-1] == 'H') {
            //                     possiblePaths--;
            //                     br = true;
            //                     break;
            //                 }
            //             }
            //         }

            //         if(br){break;}
            //     }

            //     for(int col = 0; col < N; col++) { // all down > all right
            //         boolean br = false;
            //         if(map[N-1][col] == 'H') {
            //             possiblePaths--;
            //             break;
            //         } else {
            //             for(int row = 0; row < N; row++) {
            //                 if(map[row][0] == 'H') {
            //                     possiblePaths--;
            //                     br = true;
            //                     break;
            //                 }
            //             }
            //         }

            //         if(br){break;}
            //     }
            // }
            
            // if(K >= 2) {
            //     ArrayList<int[]> takenPaths = new ArrayList<>();
            //     possiblePaths += (2*N - 4);

            //     // taking care of special cases
            //     for(int col = 0; col < N; col++) {
            //         if(map[0][col] == 'H') {
            //             possiblePaths -= (N-col-1);
            //             for(int m = col; m < N; m++) {
            //                 takenPaths.add(new int[] {0, m});
            //             }
            //             break;
            //         }
            //     }

            //     for(int row = 0; row < N; row++) {
            //         if(map[row][0] == 'H') {
            //             possiblePaths -= (N-row-1);
            //             for(int m = row; m < N; m++) {
            //                 takenPaths.add(new int[] {0, m});
            //             }
            //             break;
            //         }
            //     }
            // }
            
            // if(K >= 3) { // K == 3
            //     possiblePaths += (2*Math.pow(N, 2) -(8*N) + 8);
            // }
        //System.out.println(possiblePaths);
        }
        sc.close();
    }
}