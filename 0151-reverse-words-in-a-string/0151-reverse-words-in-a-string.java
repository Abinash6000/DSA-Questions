class Solution {
    public String reverseWords(String s) {
        // O(n) my solution then see the solution
        // can use stack to store words, then pop to create reverse string
        Stack<String> st = new Stack<>();
        boolean start = false;
        String currWord = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                start = false;
                if(currWord != "")
                    st.push(currWord);
                currWord = "";
            } else {
                start = true;
                currWord += s.charAt(i);
            }
        }

        if(currWord != "")
            st.push(currWord);

        String ans = "";
        while(!st.empty()) {
            ans += st.pop();
            if(st.empty()) break;
            ans += " ";
        }

        return ans;
    }
}