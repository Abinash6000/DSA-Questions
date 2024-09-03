class Solution {
    public String reverseWords(String s) {
        String res = "";
        s = s + ' ';
        boolean lastSpace = s.charAt(0) == ' ' ? true : false;
        String word = "";
        for(char c : s.toCharArray()) {
            if(c != ' ') {
                word = word + c;
                lastSpace = false;
            }
            if(c == ' ' && !lastSpace) {
                word = word + c;
                res = word + res;
                word = "";
                lastSpace = true;
            }
        }

        if(res.charAt(res.length()-1) == ' ') res = res.substring(0, res.length()-1);
        return res;
    }
}