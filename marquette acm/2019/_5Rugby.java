import java.util.*;

public class _5Rugby {

    /* It is unnecessary to edit the "main" method of each problem's provided code skeleton.
     * The main method is written for you in order to help you conform to input and output formatting requirements.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(;cases > 0; cases--) {
            System.out.println(countCombos(in.nextInt()));
        }
    }

    /**  
     *  TODO: Write a function that counts all combinations of points
        a team can score to reach a given total 'score'.

        @param score --> The total score for all points to add up to.
        @return the number of combinations possible. *
    */
    public static int countCombos(int score) {

        // Hint: one way to solve this problem is to write a "generateCombos" method to return
        // all the combinations, then count them:
        return generateCombos(score).size();
    }

    /**
     * T = 4
     * GK = P = 2
     * DG = 1
     * 
     * 1: 
     * DG
     * 
     * 2:
     * GK
     * P
     * 2DG
     * 
     * 3:
     * GK+DG
     * P+DG
     * 3DG
     * 
     * 4:
     * T
     * 2GK
     * 2P
     * GK+P
     * GK+2DG
     * P+2DG
     * 4DG
     * 
     * 5:
     * T+DG
     * 2GK+DG
     * 2P+DG
     * GK+DP+DG
     * GK+3DG
     * DP+3DG
     * 5DG
     * 
     * 6:
     * T+GK
     * T+P
     * T+2DG
     * 3GK
     * 3P
     * 2GK+P
     * 2P+GK
     * 2GK+2DG
     * 2P+2DG
     * GK+4DG
     * P+4DG
     * 6DG
     */
} 