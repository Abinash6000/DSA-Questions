class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }

    private int solve(String text1, String text2, int i, int j, int n1, int n2) {
        if(i == n1 || j == n2) return 0;

        char c1 = text1.charAt(i), c2 = text2.charAt(j);
        int res1 = 0, res2 = 0;
        if(c1 == c2) {
            res1 = 1 + solve(text1, text2, i+1, j+1, n1, n2);
        } else {
            // two choice -> move i or move j
            res2 = Math.max(
                solve(text1, text2, i+1, j, n1, n2),
                solve(text1, text2, i, j+1, n1, n2)
            );
        }

        return Math.max(res1, res2);
    }
}