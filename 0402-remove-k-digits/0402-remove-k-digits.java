class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c : num.toCharArray()) {
            if(st.isEmpty()) {
                st.push(c);
            } else {
                
                while (!st.isEmpty() && st.peek() > c && k!=0) {
                    st.pop();
                    k--;
                }
                
                st.push(c);
            }
        }

        // handle case when k is not 0 yet
        while(k != 0) {
            st.pop();
            k--;
        }

        // build the string
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        // remove trailing zeroes so that 0001000 numbers like this become 1000
        while(sb.length() != 1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }

        // reverse the sb
        sb.reverse();
        
        return sb.toString();
    }
}