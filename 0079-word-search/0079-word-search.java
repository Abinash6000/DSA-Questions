class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (board[i][j]==word.charAt(0)) {
                    if (helper(board, word, i, j, board.length, board[0].length, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i, int j, int m, int n, int k) {
        if(k>=word.length()) return true;
        if(i<0 || j<0 || i==m || j==n) return false;
        if(board[i][j]!=word.charAt(k)) return false;
        board[i][j]='.';
        boolean res = false;
        // check up
        res = (helper(board, word, i-1, j, m, n, k+1) || res);
        // check down
        res = (res || helper(board, word, i+1, j, m, n, k+1));
        // check right
        res = (res || helper(board, word, i, j+1, m, n, k+1));
        // check left
        res = (res || helper(board, word, i, j-1, m, n, k+1));
        board[i][j]=word.charAt(k);
        return res;
    }
}