class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int row_s = 0;
        int col_s = 0;
        int row_e = matrix.length-1;
        int col_e = matrix[0].length-1;
        

        while(true) {

            for (int c = col_s; c<=col_e; c++) 
                res.add(matrix[row_s][c]);
            row_s++;
            if(row_s>row_e || col_s>col_e) break;

            for (int r = row_s; r<=row_e; r++) 
                res.add(matrix[r][col_e]);
            col_e--;
            if(row_s>row_e || col_s>col_e) break;

            for (int c = col_e; c>=col_s; c--) 
                res.add(matrix[row_e][c]);
            row_e--;
            if(row_s>row_e || col_s>col_e) break;

            for (int r = row_e; r>=row_s; r--) 
                res.add(matrix[r][col_s]);
            col_s++;
            if(row_s>row_e || col_s>col_e) break;

        }

        return res;
    }
}