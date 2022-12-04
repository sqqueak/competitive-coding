import java.util.Scanner;

public class _7Encryption {


    /* It is unnecessary to edit the "main" method of each problem's provided code skeleton.
        * The main method is written for you in order to help you conform to input and output formatting requirements.
        */	
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(;cases > 0; cases--)
            System.out.println(encode(in.next()));
        in.close();
    }
    
    /* TODO: Implement the "square encryption" scheme 
        * @param s, the message to encrypt, of type String 
        * @return s, the encrypted message
        */ 
    private static String encode(String s) {
        int len = s.length();
        char[][] enc = new char[(int)Math.ceil(Math.sqrt(len))][(int)Math.ceil(Math.sqrt(len))];
        int i = 0;

        while(i < len) {
            for(int row = 0; row < Math.ceil(Math.sqrt(len)); row++) {
                for(int col = 0; col < Math.ceil(Math.sqrt(len)); col++) {
                    enc[row][col] = s.charAt(i);
                    i++;
                    if(i == len) break;            
                }
                if(i == len) break;
            }
        }

        s = "";
        for(int col = 0; col < Math.ceil(Math.sqrt(len)); col++) {
            for(int row = 0; row < Math.ceil(Math.sqrt(len)); row++) {
                s+=enc[row][col];            
            }
            s+=(" ");
        }

        return s;
    }
}
