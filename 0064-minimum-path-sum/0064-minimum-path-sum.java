class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return solve(grid, 0, 0);
    }

    private int solve(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
        if (memo[i][j] != 0) return memo[i][j];

        int right = solve(grid, i, j+1);
        int down  = solve(grid, i+1, j);

        return memo[i][j] = grid[i][j] + Math.min(right, down);
    }
}
