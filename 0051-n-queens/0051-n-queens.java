class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(n, 0, board, boards);
        return boards;
    }

    private boolean isSafe(int i, int j, char[][] board) {
        int n = board.length;
        // up
        for(int up = 0; up<i; up++) 
            if(board[up][j] == 'Q') return false;
        // up left
        for(int ith = i-1, jth = j-1; ith>=0 && jth>=0; ith--,jth--) 
            if(board[ith][jth] == 'Q') return false;
        // up right
        for(int ith = i-1, jth = j+1; ith>=0 && jth<n; ith--,jth++)
            if(board[ith][jth] == 'Q') return false;

        return true;
    }

    private void helper(int n, int i, char[][] board, List<List<String>> boards) {
        if(i == n) {
            List<String> newBoard = new ArrayList<>();
            for(int  k= 0; k<n; k++) {
                String row = "";
                for(int l = 0; l<n; l++) {
                    row += (board[k][l] == 'Q' ? 'Q' : '.');
                }
                newBoard.add(row);
            }
            boards.add(newBoard);
            return;
        }

        for(int j = 0; j<n; j++)  {
            if(isSafe(i, j, board)) {
                board[i][j] = 'Q';
                helper(n, i+1, board, boards);
                board[i][j] = '.';
            }
        }
    }
}