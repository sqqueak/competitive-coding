
/*
ID: heyitssqueak
LANG: JAVA
TASK: abcs
*/
import java.io.*;
import java.util.StringTokenizer;

public class abcs {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer string = new StringTokenizer(f.readLine());

        int[] numbers = new int[7];

        for (int i = 0; i < 7; i++) {
            numbers[i] = Integer.parseInt(string.nextToken());
        }

        int a = (int) Float.POSITIVE_INFINITY;
        int b = (int) Float.POSITIVE_INFINITY;
        int c = (int) Float.POSITIVE_INFINITY;
        int largest = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        boolean isWorking = false;

        while(isWorking == false) {
        int[] numbersCopy = numbers;

        for (int i = 0; i < numbersCopy.length; i++) {
            a = numbersCopy[i];
            for (int j = 0; j < numbersCopy.length; j++) {

                if (i == j) {

                } else {
                    b = numbersCopy[j];
                    for (int k = 0; k < numbersCopy.length; k++) {

                        if (j == k) {

                        } else {
                            c = numbersCopy[k];
                            if ((a + b + c) == largest) {
                                numbersCopy[k] = 0;
                                numbersCopy[j] = 0;
                                numbersCopy[i] = 0;
                                break;
                            }
                        }

                    }
                    if ((a + b + c) == largest) {
                        break;
                    }
                }

            }
            if ((a + b + c) == largest) {
                break;
            }
        }

        //System.out.println(a + " " + b + " " + c);

        // System.out.println(a + b);
        // System.out.println(b + c);
        // System.out.println(a + c);

        boolean ab = false;
        boolean bc = false;
        boolean ca = false;

        // for (int i = 0; i < numbersCopy.length; i++) {
        //     System.out.println(numbersCopy[i]);
        // }

        if (a + b + c == largest) {
            int[] remaining = new int[4];
            int counter = 0;

            for (int i = 0; i < numbersCopy.length; i++) {
                if (numbersCopy[i] != 0) {
                    remaining[counter] = numbersCopy[i];
                    // System.out.println(remaining[counter]);
                    counter++;
                }
            }

            for (int i = 0; i < remaining.length; i++) {
                if (ab == false && a + b == remaining[i]) {
                    ab = true;
                    remaining[i] = 0;
                }
                if (bc == false && b + c == remaining[i]) {
                    bc = true;
                    remaining[i] = 0;
                }
                if (ca == false && c + a == remaining[i]) {
                    ca = true;
                    remaining[i] = 0;
                }

                if (ab == true && bc == true && ca == true) {
                    isWorking = true;
                }
            }

        } else {

        }

        }

        if(a <= b && b <= c) {
            System.out.println(a + " " + b + " " + c);
        } else if(a <= c && c <= b) {
            System.out.println(a + " " + c + " " + b);
        } else if(b <= a && a <= c) {
            System.out.println(b + " " + a + " " + c);
        } else if(b <= c && c <= a) {
            System.out.println(b + " " + c + " " + a);
        } else if(c <= a && a <= b) {
            System.out.println(c + " " + a + " " + b);
        } else if(c <= b && b <= a) {
            System.out.println(c + " " + b + " " + a);
        }

        // for(int i = 0; i < numbers.length; i++) {
        // if(numbers[i] < a) {
        // a = numbers[i];
        // numbers[i] = 0;
        // }

        // if(numbers[i] > largest) {
        // largest = numbers[i];
        // }
        // }

        // for(int i = 0; i < numbers.length; i++) {
        // if(numbers[i] < b && numbers[i] != 0) {
        // b = numbers[i];
        // numbers[i] = 0;
        // }
        // }

        // for(int i = 0; i < numbers.length; i++) {
        // if(numbers[i] < c && numbers[i] != 0) {
        // c = numbers[i];
        // numbers[i] = 0;
        // }
        // }

        // System.out.println(largest);
        // System.out.println(a + " " + b + " " + c);
        // System.out.println(a + b + c);

        f.close();
    }
}