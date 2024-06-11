class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }
    private boolean solveSudoku(char[][] board, int row, int col) {
        // base case
        if(row == board.length) return true;

        int nrow = 0;
        int ncol = 0;
        if(col == board.length-1) {
            ncol = 0;
            nrow = row+1;
        } else {
            ncol = col+1;
            nrow = row;
        }

        if(board[row][col] != '.') {
           if (solveSudoku(board, nrow, ncol)) return true;
        } else {
            for(int i = 1; i<10; i++) {
                if(isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i+'0');
                    if(solveSudoku(board, nrow, ncol)) return true;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    private boolean isSafe(char[][] board, int row, int col, int num) {
        // row & column
        for (int i = 0; i<board.length; i++) {
            if (board[i][col]==(char)(num+'0')) return false;
            if (board[row][i]==(char)(num+'0')) return false;
        }
        //subgrid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i<sr+3; i++) {
            for (int j = sc; j<sc+3; j++) {
                if (board[i][j] == (char)(num+'0')) return false;
            }
        }
        return true;
    }
}