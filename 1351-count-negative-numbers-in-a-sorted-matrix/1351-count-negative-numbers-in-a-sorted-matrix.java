class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                if(grid[i][j] < 0)
                    res++;

        return res;
    }
}