class NumMatrix {
    int prefixSum[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefixSum = new int[m][n];
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(i == 0 && j == 0) {
                    prefixSum[0][0] = matrix[0][0];
                } else if(i == 0) {
                    prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
                } else if(j == 0) {
                    prefixSum[i][j] = prefixSum[i-1][j] + matrix[i][j];
                } else {
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i][j];
                }
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print(prefixSum[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int currSum = prefixSum[row2][col2];
        if(col1 > 0)
            currSum -= prefixSum[row2][col1-1];
        if(row1 > 0) 
            currSum -= prefixSum[row1-1][col2];
        if(row1 != 0 && col1 != 0) 
            currSum += prefixSum[row1-1][col1-1];

        return currSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */