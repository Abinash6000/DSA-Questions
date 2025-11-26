class Solution {
    static final int mod = (int) 1e9+7;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] memo = new int[m][n][k];

        int res = helper(0, 0, k, memo, grid, 0);
        return res < 0 ? 0 : res;
    }

    private int helper(int i, int j, int k, int[][][] memo, int[][] grid, int sum) {
        if(i == grid.length-1 && j == grid[0].length-1) {
            int newSum = (sum + grid[i][j]) % k;
            if(newSum == 0)
                return 1;
            else 
                return Integer.MIN_VALUE;
        }

        if(i == grid.length || j == grid[0].length)
            return Integer.MIN_VALUE;
        

        if(memo[i][j][sum] != 0)
            return memo[i][j][sum];

        long paths1 = helper(i+1, j, k, memo, grid, (sum + grid[i][j]) % k);
        long paths2 = helper(i, j+1, k, memo, grid, (sum + grid[i][j]) % k);
            
        if(paths1 > 0 && paths2 > 0)
            return memo[i][j][sum] = (int) ((paths1 + paths2) % mod);
        else
            return memo[i][j][sum] = (int) Math.max(paths1, paths2);
    }
}