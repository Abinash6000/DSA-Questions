class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int res[] = new int[1];

        for(char[] row : board)
            Arrays.fill(row, '.');

        solve(board, res, 0);
        return res[0];
    }

    private void solve(char[][] board, int[] res, int col) {
        if(col == board.length) {
            res[0]++;
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, res, col+1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for(int i = 0; i<col; i++) {
            if(board[row][i] == 'Q') return false;
        }

        for(int i = row-1, j = col-1; i>=0 && j>=0; ) {
            if(board[i][j] == 'Q') return false;
            i--; j--;
        }

        for(int i = row+1, j = col-1; i<board.length && j>=0; ) {
            if(board[i][j] == 'Q') return false;
            i++; j--;
        }

        return true;
    }
}