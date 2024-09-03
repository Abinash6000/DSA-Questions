class Solution {
    public String removeOuterParentheses(String s) {
        int o = 0, stIdx = -1;
        String res = "";
        for(int i = 0; i<s.length(); i++) {
            if(o == 0) 
                stIdx = i;
            
            if(s.charAt(i) == '(')
                o++;
            else 
                o--;

            if(o == 0)
                res = res + s.substring(stIdx+1, i);
        }

        return res;
    }
}