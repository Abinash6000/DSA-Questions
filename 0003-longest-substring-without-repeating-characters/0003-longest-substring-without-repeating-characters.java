class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        HashMap<Character, Integer> map = new HashMap<>(); // char, index
        int maxLen = 0, st = 0; // st is start of substring

        for(int i = 0; i<s.length(); ++i) { // i is end of substring
            char currChar = s.charAt(i);

            if(map.containsKey(currChar)) {
                st = Math.max(st, map.get(currChar)+1);
            }
            maxLen = Math.max(maxLen, i-st+1);
            map.put(currChar, i);
        }

        return maxLen;
    }
}