class Solution {
    public String longestPrefix(String s) {
        int m = s.length(), lps[] = new int[m];
        int i = 1, len = 0; // len is length of previous longest prefix suffix

        while(i<m) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, len);
    }
}