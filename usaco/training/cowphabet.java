/*
ID: heyitssqueak
LANG: JAVA
TASK: cowphabet
*/
import java.io.*;

public class cowphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = f.readLine().toCharArray();
        char[] word = f.readLine().toCharArray();

        int alphabetCounter = 0;
        int wordLetterCounter = 0;

        while(wordLetterCounter != word.length) {

            for(int i = 0; i < 26; i++) {
                if(word[wordLetterCounter] == alphabet[i]) {
                    if(wordLetterCounter == word.length) {
                        break;
                    } else {
                        wordLetterCounter++;
                    }
                }
                alphabetCounter++;
            }
        }

        System.out.println(alphabetCounter);

        f.close();
    }
}