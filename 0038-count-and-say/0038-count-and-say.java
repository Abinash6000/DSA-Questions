class Solution {
    public String countAndSay(int n) {
        if (n == 0) return "";
        String res = "1";
        while (--n != 0) {
            String cur = "";
            for (int i = 0; i < res.length(); i++) {
                int count = 1;
                while ((i + 1 < res.length()) && (res.charAt(i) == res.charAt(i + 1))){
                    count++;    
                    i++;
                }
                cur += (count+ "" + res.charAt(i));
            }
            res = cur;
        }
        return res;
    }
}