/*
ID: heyitssqueak
LANG: JAVA
TASK: photos
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class printing {

    public static void main(String[] args) {

        ArrayList<String> perms = new ArrayList<String>();
        permutation("", "1234", perms);

        for(String item : perms) {
            System.out.println(item);
        }

        System.out.println(perms.size());
    }
    
    public static void permutation(String comb, String str, ArrayList<String> list) {
        int n = str.length();
        if (n == 0) {
            list.add(comb);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(comb + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list);
            }
        }
    }
}