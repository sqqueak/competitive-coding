/*
ID: heyitssqueak
LANG: JAVA
TASK: cowphabet
*/
import java.io.*;

public class cowphabet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = f.readLine().toCharArray();
        char[] word = f.readLine().toCharArray();

        int alphabetCounter = 1;
        int wordLetterCounter = 0;

        while(wordLetterCounter != word.length) {

            for(int i = 0; i < alphabet.length; i++) {
                if(word[wordLetterCounter] == alphabet[i]) {
                    wordLetterCounter++;

                    if(wordLetterCounter == word.length) {
                        break;
                    }
                }
                if(i == alphabet.length - 1) {
                    alphabetCounter++;
                }
            }
        }

        System.out.println(alphabetCounter);

        f.close();
    }
}