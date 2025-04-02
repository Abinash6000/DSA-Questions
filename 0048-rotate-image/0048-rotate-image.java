class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose of matrix
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse matrix over vertical middle axis
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n/2; j++) {
                // swap
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}