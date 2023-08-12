class MinStack {

    Stack<int[]> st;

    public MinStack() {
        this.st  = new Stack<>();
    }
    
    public void push(int val) {
        int[] pair;
        if(!st.isEmpty())
            pair = new int[]{val, Math.min(val, st.peek()[1])};
        else 
            pair = new int[]{val, val};
        st.push(pair);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */