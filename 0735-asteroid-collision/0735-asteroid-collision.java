class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(ast[i] > 0 || s.empty()) {
                s.push(ast[i]);
            } else {
                while(!s.empty() && s.peek() > 0 && s.peek() < Math.abs(ast[i])) {
                    s.pop();
                }
                if(!s.empty() && s.peek() == Math.abs(ast[i])) {
                    s.pop();
                }
                else {
                    if(s.empty() || s.peek() < 0) {
                        s.push(ast[i]);
                    }
                }
            }
        }
		// finally we are returning the elements which remains in the stack.
		// we have to return them in reverse order.
        int[] res = new int[s.size()];
        for(int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.peek();
            s.pop();
        }
        return res;
    }
}