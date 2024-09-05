class Solution {
    public String longestPalindrome(String s) {
        // the trick is to try to extend on every index, the palindromic substring
        // this gives almost O(n) time complexity
        
        String longestPalindrome = "";

        for(int i = 0; i < s.length(); i++) {
            String s1 = extend(i, i, s), s2 = extend(i, i+1, s);

            if(longestPalindrome.length() < s1.length()) {
                longestPalindrome = s1;
            }
            if(longestPalindrome.length() < s2.length()) {
                longestPalindrome = s2;
            }
        }

        return longestPalindrome;
    }

    private String extend(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }
}