class Solution {
    public int uniquePaths(int r, int c) {
        int dp[][] = new int[2][c];
        for(int i = 0; i<2; i++) {
            for(int j = 0; j<n; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 1;
            }
        }

        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                dp[i%2][j] = dp[(i-1)%2][j] + dp[i%2][j-1];
            }
        }

        return dp[(r-1)%2][c-1];
    }

    // private int up(int r, int c, Integer[][] memo) {
    //     if(r == 0 || c == 0) return 0;
    //     if(r == 1 && c == 1) return 1;
    //     if(memo[r][c] != null) return memo[r][c];

    //     return memo[r][c] = (up(r-1, c, memo) + up(r, c-1, memo));
    // }
}