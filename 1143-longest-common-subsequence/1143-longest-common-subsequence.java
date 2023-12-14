class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int memo[][] = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i<s1.length(); i++) {
            for(int j = 0; j<s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) memo[i+1][j+1] = 1 + memo[i][j];
                else memo[i+1][j+1] = Math.max(memo[i][j+1], memo[i+1][j]);
            }
        }

        return memo[s1.length()][s2.length()];
        // return helper(s1, s2, s1.length()-1, s2.length()-1);
    }

    // private int helper(String s1, String s2, int s1Ind, int s2Ind) {
    //     if(s1Ind ==  -1|| s2Ind == -1) {
    //         return 0;
    //     }
    //     if(memo[s1Ind][s2Ind] != null) return memo[s1Ind][s2Ind];

    //     if(s1.charAt(s1Ind) == s2.charAt(s2Ind)) {
    //         return memo[s1Ind][s2Ind] = 1 + helper(s1, s2, s1Ind-1, s2Ind-1);
    //     } else {
    //         return memo[s1Ind][s2Ind] = Math.max(helper(s1, s2, s1Ind-1, s2Ind),
    //                                              helper(s1, s2, s1Ind, s2Ind-1));
    //     }
    // }
}