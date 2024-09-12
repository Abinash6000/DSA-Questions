class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    board[i][j] = '.';
                    if(exist(board, i, j, word, 1)) return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int k) {
        if(k == word.length()) return true;

        if(i != 0 && board[i-1][j] == word.charAt(k)) {
            board[i-1][j] = '.';
            if(exist(board, i-1, j, word, k+1)) return true;
            board[i-1][j] = word.charAt(k);
        }
        if(j != 0 && board[i][j-1] == word.charAt(k)) {
            board[i][j-1] = '.';
            if(exist(board, i, j-1, word, k+1)) return true;
            board[i][j-1] = word.charAt(k);
        }
        if(i != board.length-1 && board[i+1][j] == word.charAt(k)) {
            board[i+1][j] = '.';
            if(exist(board, i+1, j, word, k+1)) return true;
            board[i+1][j] = word.charAt(k);
        }
        if(j != board[0].length-1 && board[i][j+1] == word.charAt(k)) {
            board[i][j+1] = '.';
            if(exist(board, i, j+1, word, k+1)) return true;;
            board[i][j+1] = word.charAt(k);
        }

        return false;
    }
}