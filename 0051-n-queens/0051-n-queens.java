class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(boards, board, 0);
        return boards;
    }

    private void helper(List<List<String>> boards, char[][] board, int col) {
        if(col == board.length) {
            addBoard(boards, board);
            return;
        }

        for(int row = 0; row<board.length; row++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                helper(boards, board, col+1);
                board[row][col] = '.';
            } else {
                board[row][col] = '.';
            }
        }
    }

    private void addBoard(List<List<String>> boards, char[][] board) {
        List<String> newBoard = new ArrayList<>();
        for(int i = 0; i<board.length; i++) {
            String row = "";
            for(int j = 0; j<board.length; j++) {
                if(board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        boards.add(newBoard);
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // left
        for(int i = row, j = col-1; j>=0; j--) {
            if(board[i][j] == 'Q') return false;
        }
        // top left
        for(int i = row-1, j = col-1; (j>=0 && i>=0); j--, i--) {
            if(board[i][j] == 'Q') return false;
        }
        // bottom left
        for(int i = row+1, j = col-1; j>=0 && i<board.length; j--, i++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}