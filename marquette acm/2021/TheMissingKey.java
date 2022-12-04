import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheMissingKey {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int powMod(int b, int e, int m) {
        return java.math.BigInteger.valueOf(b).modPow(java.math.BigInteger.valueOf(e), java.math.BigInteger.valueOf(m))
                .intValue();
    }

    public static String decode(int[] message) {
        return java.util.Arrays.stream(message).mapToObj(i -> Character.toString((char) i))
                .collect(java.util.stream.Collectors.joining());
    }

    /**
     * Complete this method that finds a plaintext containing "Ahoya!"
     * 
     * @param p          --> p-value from the algorithm.
     * @param q          --> q-value from the algorithm.
     * @param ciphertext --> ciphertext represented as an array of integers
     * 
     * @return {string} - decoded plaintext as a string
     */
    public static String codebreak(int p, int q, int[] m) {

        // Write your code here

        int n = p * q;
        int func = (p - 1) * (q - 1);

        ArrayList<Integer[]> workingD = new ArrayList<>();

        ArrayList<Integer> workingE = new ArrayList<>();
        for (int i = 2; i < func; i++) {
            if (gcd(func, i) == 1) {
                workingE.add(i);
            }
        }

        for (int e : workingE) {
            for (int i = 0; i < 200; i++) {
                if ((i * e) % func == 1) {
                    workingD.add(new Integer[] { e, i });
                }
            }
        }

        // for(int i = 0; i < m.length; i++) {
        // System.out.print(m[i] + " ");
        // }
        // System.out.println();

        ArrayList<int[]> moddedMessage = new ArrayList<>();
        // modding nums
        for (int i = 0; i < workingD.size(); i++) {
            int[] mod = new int[m.length];

            for (int j = 0; j < m.length; j++) {
                mod[j] = powMod(m[j], workingD.get(i)[1], n);
            }
            moddedMessage.add(mod);
        }

        // message, e, d
        ArrayList<int[]> messages = new ArrayList<>();
        ArrayList<Integer[]> finalE = new ArrayList<>();

        for (int i = 0; i < workingD.size(); i++) {
            if (decode(moddedMessage.get(i)).equals("Ahoya!")) {
                messages.add(moddedMessage.get(i));
                finalE.add(workingD.get(i));
            }
        }

        // System.out.println("messages");
        // for (int[] message : messages) {
        //     for (int i = 0; i < message.length; i++) {
        //         System.out.print(message[i] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("eeeees:");
        // for (int i = 0; i < finalE.size(); i++) {
        //     System.out.println(finalE.get(i)[0] + " " + finalE.get(i)[1]);
        // }

        ArrayList<int[]> FINALMESSAGES = new ArrayList<>();
        ArrayList<Integer[]> FINALNUMS = new ArrayList<>();

        for(Integer[] pair : finalE) {
            for(int[] message : messages) {
                int counter = 0;
                boolean isValid = false;
                for(int character : message) {
                    int test = powMod(character, pair[0], n);
                    if(test != m[counter]) {
                        isValid = false;
                        break;
                    } else {
                        counter++;
                        isValid = true;
                    }
                }
                if(isValid) FINALMESSAGES.add(message);
                if(isValid) FINALNUMS.add(pair);
            }
        }

        // for(int i = 0; i < FINALMESSAGES.size(); i++) {
        //     for(int character : FINALMESSAGES.get(i)) {
        //         System.out.print(character);
        //     }
        //     System.out.println();
        // }

        // for(Integer[] pair : FINALNUMS) {
        //     System.out.println(pair[0] + " " + pair[1]);
        // }
        return decode(FINALMESSAGES.get(0));

        // for(int[] message : FINALMESSAGES) {
        //     System.out.println(decode(message));
        // }

        // for (int i = 0; i < messages.size(); i++) {
        // int[] message = messages.get(i);
        // for (int j = 0; j < m.length; j++) {
        // int test = powMod(message[j], finalE.get(i)[0], n);
        // if (test != m[j]) {
        // break;
        // } else {
        // FINALMESSAGES.add(message);
        // }
        // }
        // }

        // for(int[] message : FINALMESSAGES) {
        // for(int i = 0; i < message.length; i++) {
        // System.out.print(message[i]);
        // }
        // System.out.println();
        // }

        // for (int[] message : FINALMESSAGES) {
        // for(int i = 0; i < message.length; i++) {
        // System.out.print(message[i]);
        // }
        // System.out.println();
        // // System.out.println(decode(message));
        // }

        // return " ";
    }

    /*
     * It is unnecessary to edit the "main" method of each problem's provided code
     * skeleton. The main method is written for you in order to help you conform to
     * input and output formatting requirements.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int tests = in.nextInt(); tests > 0; tests--) {
            int p = in.nextInt();
            int q = in.nextInt();

            int[] c = java.util.Arrays.stream(in.next().split("(?<=\\G..)")).mapToInt(s -> Integer.parseInt(s, 16))
                    .toArray();

            System.out.println(codebreak(p, q, c));
        }
        in.close();
    }
}