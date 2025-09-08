class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()+1][word2.length()+1];
        int lcs = lcs(word1, word2, 0, 0, memo);
        return lcs;
    }

    private int lcs(String s1, String s2, int i, int j, int[][] memo) {
        if(i == s1.length())
            return s2.length()-j;
        if(j == s2.length())
            return s1.length()-i;
        if(memo[i][j] != 0)
            return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = lcs(s1, s2, i+1, j+1, memo);
        }

        return memo[i][j] = 1 + Math.min(lcs(s1, s2, i+1, j, memo), Math.min(lcs(s1, s2, i, j+1, memo), lcs(s1, s2, i+1, j+1, memo)));
    }
}