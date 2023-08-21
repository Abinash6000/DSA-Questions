class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        int idx = -1;
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0) && isOccur(i, 0, haystack, needle)) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    private boolean isOccur(int i, int j, String haystack, String needle) {
        while(i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
            i++;
            j++;
        }

        return  j == needle.length();
    }
}