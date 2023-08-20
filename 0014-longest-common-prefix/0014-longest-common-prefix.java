class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0; 
            while(j < strs[i].length() && j < lcp.length() && strs[i].charAt(j) == lcp.charAt(j))
                j++;
            
            lcp = lcp.substring(0, j);
        }

        return lcp;
    }
}