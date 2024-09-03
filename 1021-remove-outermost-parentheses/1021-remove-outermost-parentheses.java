class Solution {
    public String removeOuterParentheses(String s) {
        int o = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(o != 0)
                    res.append('(');
                o++;
            }
            else {
                if(o != 1)
                    res.append(')');
                o--;
            }
        }

        return res.toString();
    }
}