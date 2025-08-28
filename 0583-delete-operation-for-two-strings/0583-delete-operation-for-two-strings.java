class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];

        for(int i = 0; i<=n1; i++) {
            for(int j = 0; j<=n2; j++) {
                if(i == 0 || j == 0) 
                    curr[j] = 0;
                else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) 
                        curr[j] = prev[j-1]+1;
                    else 
                        curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }

            prev = curr.clone();
        }

        int lcs = curr[n2];
        return n1-lcs + n2-lcs;
    }
}