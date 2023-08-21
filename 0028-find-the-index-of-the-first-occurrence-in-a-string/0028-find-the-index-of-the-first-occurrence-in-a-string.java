class Solution {
    public int strStr(String haystack, String needle) {
        int idx = -1;
        outer: for(int i = 0; i < haystack.length(); i++) {
            for(int j = i+1; j <= haystack.length(); j++) {
                if(haystack.substring(i, j).equals(needle)) {
                    idx = i;
                    break outer;
                }
            }
        }

        return idx;
    }
}