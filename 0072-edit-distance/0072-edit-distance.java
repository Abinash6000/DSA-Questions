class Solution {
    public int minDistance(String w1, String w2) {
        int[][] dp = new int[w1.length()+1][w2.length()+1];
        // initialization
        for(int i = 0; i<= w1.length(); i++) dp[i][0] = i;
        for(int j = 0; j<= w2.length(); j++) dp[0][j] = j;

        for(int i = 1; i<= w1.length(); i++) {
            for(int j = 1; j<= w2.length(); j++) {
                if(w1.charAt(i-1) == w2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int ins = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int rep = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(ins, Math.min(del, rep));
                }
            }
        }

        return dp[w1.length()][w2.length()];
    }

    // private int editDis(String w1, String w2, int i, int j, Integer[][] memo) {
    //     if(j == w2.length()) return (w1.length() - i);
    //     if(i == w1.length()) return (w2.length() - j);
    //     if(memo[i][j] != null) return memo[i][j];

    //     if(w1.charAt(i) == w2.charAt(j)) return memo[i][j] = editDis(w1, w2, i+1, j+1, memo);
    //     else {
    //         int ins = 1 + editDis(w1, w2, i, j+1, memo);
    //         int del = 1 + editDis(w1, w2, i+1, j, memo);
    //         int rep = 1 + editDis(w1, w2, i+1, j+1, memo);
    //         return memo[i][j] = Math.min(ins, Math.min(del, rep));
    //     }
    // }
}