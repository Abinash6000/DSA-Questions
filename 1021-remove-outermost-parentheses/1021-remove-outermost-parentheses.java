class Solution {
    public String removeOuterParentheses(String s) {
        int o = 0;
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
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