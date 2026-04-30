class Solution {

    public int maxPathScore(int[][] grid, int k) {
        int dp[][][] = new int[grid.length][grid[0].length][k + 1], max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i > 0 ? 0 : 1; j < grid[0].length; j++) {
                for (int l = Math.min(k, i + j); l >= 0; l--) {
                    if (i > 0 && l - (grid[i][j] > 0 ? 1 : 0) >= 0 && dp[i - 1][j][l - (grid[i][j] > 0 ? 1 : 0)] >= 0) {
                        dp[i][j][l] = dp[i - 1][j][l - (grid[i][j] > 0 ? 1 : 0)] + grid[i][j];
                    }
                    if (j > 0 && l - (grid[i][j] > 0 ? 1 : 0) >= 0 && dp[i][j - 1][l - (grid[i][j] > 0 ? 1 : 0)] >= 0) {
                        dp[i][j][l] = Math.max(dp[i][j][l], dp[i][j - 1][l - (grid[i][j] > 0 ? 1 : 0)] + grid[i][j]);
                    }
                }
            }
        }
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, dp[grid.length - 1][grid[0].length - 1][i]);
        }
        return max;
    }
}