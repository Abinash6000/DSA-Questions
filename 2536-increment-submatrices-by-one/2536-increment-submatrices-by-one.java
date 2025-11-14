class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n+1];
        for(int[] q : queries) {
            int sr = q[0], sc = q[1], er = q[2], ec = q[3];
            for(int r = sr; r<=er; r++) {
                res[r][sc]++;
                res[r][ec+1]--;
            }
        }

        int curr = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n+1; j++)  {
                curr += res[i][j];
                res[i][j] = curr;
            }
        }

        int[][] finalRes = new int[n][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                finalRes[i][j] = res[i][j];

        return finalRes;
    }
}