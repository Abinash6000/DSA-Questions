class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fstRow = false, fstCol = false;
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0 || j == 0) {
                        fstRow = i == 0 ? true : fstRow;
                        fstCol = j == 0 ? true : fstCol;
                        continue;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i = 1; i<matrix.length; i++) {
            for(int j = 1; j<matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(fstRow) 
            for(int i = 0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        
        if(fstCol) 
            for(int i = 0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
    }
}