class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return editDis(word1, word2, 0, 0, memo);
    }

    private int editDis(String w1, String w2, int i, int j, Integer[][] memo) {
        if(j == w2.length()) return (w1.length() - i);
        if(i == w1.length()) return (w2.length() - j);
        if(memo[i][j] != null) return memo[i][j];

        if(w1.charAt(i) == w2.charAt(j)) return memo[i][j] = editDis(w1, w2, i+1, j+1, memo);
        else {
            int ins = 1 + editDis(w1, w2, i, j+1, memo);
            int del = 1 + editDis(w1, w2, i+1, j, memo);
            int rep = 1 + editDis(w1, w2, i+1, j+1, memo);
            return memo[i][j] = Math.min(ins, Math.min(del, rep));
        }
    }
}