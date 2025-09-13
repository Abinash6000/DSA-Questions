class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fstR = false;
        boolean fstC = false;

        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        fstR = true; fstC = true;
                    } else if(i == 0) {
                        fstR = true;
                    } else if(j == 0) {
                        fstC = true;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // cols
        for(int i = 1; i<n; i++) {
            if(matrix[0][i] == 0)
                for(int j = 1; j<m; j++) 
                    matrix[j][i] = 0;
        }

        // rows
        for(int i = 1; i<m; i++) {
            if(matrix[i][0] == 0)
                for(int j = 1; j<n; j++)
                    matrix[i][j] = 0;
        }

        if(fstR)
            for(int i = 0; i<n; i++)
                matrix[0][i] = 0;

        if(fstC)
            for(int j = 0; j<m; j++)
                matrix[j][0] = 0;
    }
}