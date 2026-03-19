class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[n][2];
        int subMats = 0;

        for(int i = 0; i < m; i++) {
            int xs = 0, ys = 0;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'X') {
                    xs++;
                } else if(grid[i][j] == 'Y') {
                    ys++;
                }

                rowSum[j][0] += xs;
                rowSum[j][1] += ys;
                
                if(rowSum[j][0] == rowSum[j][1] && rowSum[j][0] != 0)
                    subMats++;
            }
        }

        return subMats;
    }
}