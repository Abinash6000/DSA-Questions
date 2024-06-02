class Solution {
    public int uniquePaths(int r, int c) {
        Integer memo[][] = new Integer[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || j == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }

        return memo[r-1][c-1];
    }

    // private int up(int r, int c, Integer[][] memo) {
    //     if(r == 0 || c == 0) return 0;
    //     if(r == 1 && c == 1) return 1;
    //     if(memo[r][c] != null) return memo[r][c];

    //     return memo[r][c] = (up(r-1, c, memo) + up(r, c-1, memo));
    // }
}