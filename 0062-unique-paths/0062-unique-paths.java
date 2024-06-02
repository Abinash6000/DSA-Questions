class Solution {
    public int uniquePaths(int r, int c) {
        Integer memo[][] = new Integer[r+1][c+1];
        return up(r, c, memo);
    }

    private int up(int r, int c, Integer[][] memo) {
        if(r == 0 || c == 0) return 0;
        if(r == 1 && c == 1) return 1;
        if(memo[r][c] != null) return memo[r][c];

        return memo[r][c] = (up(r-1, c, memo) + up(r, c-1, memo));
    }
}