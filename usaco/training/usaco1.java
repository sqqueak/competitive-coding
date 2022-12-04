import java.util.Scanner;

public class usaco1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cowTypes = sc.nextLine().toCharArray();
        sc.close();

        int fakePhotos = 0;

        for(int i = 0; i < cowTypes.length - 2; i++) {
            for(int j = i+2; j < cowTypes.length; j++) {
                boolean allThreeTrue = false;

                int H = 0;
                int G = 0;

                for(int m = i; m <= j; m++ ) {
                    if(cowTypes[m] == 'H') {
                        H++;
                    } else if(cowTypes[m] == 'G') {
                        G++;
                    }
                }

                for(int m = i; m < j; m++) {
                    if(cowTypes[m] != cowTypes[m+1]) {
                        allThreeTrue = false;
                        break;
                    } else {
                        allThreeTrue = true;
                    }
                }

                // if(j-i == 2 && cowTypes[i] == cowTypes[i+1] && cowTypes[i] == cowTypes[i+2]) {
                //     allThreeTrue = true;
                // }

                if(H >= 2 && G >= 2 && !allThreeTrue) {
                    // System.out.print("REAL:");
                    // for(int m = i; m <= j; m++ ) {
                    //     System.out.print(cowTypes[m]);
                    // }
                    // System.out.println();

                    break;
                } else if(allThreeTrue) {
                    // System.out.print("REAL:");

                    // for(int m = i; m <= j; m++ ) {
                    //     System.out.print(cowTypes[m]);
                    // }
                    // System.out.println();
                    // System.out.println("HELLO");
                } else {
                    // System.out.print("FAKE:");
                    // for(int m = i; m <= j; m++ ) {
                    //     System.out.print(cowTypes[m]);
                    // }
                    // System.out.println();
                    fakePhotos++;
                }

                // System.out.println();

                // if(j-i == 2 && (cowTypes[i] == cowTypes[i+1] && cowTypes[i] == cowTypes[i+2])) { // testing length 3
                //     allThreeTrue = true;

                // } else if(allThreeTrue) { // 


                // } else {

                // }
            }
        }

        System.out.println(fakePhotos);
    }
}
