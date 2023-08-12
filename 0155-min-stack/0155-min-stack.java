class MinStack {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return this.key;
        }

        int getValue() {
            return this.value;
        }
    }

    Stack<Pair> st;
    int currMin;

    public MinStack() {
        this.st  = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        currMin = Math.min(currMin, val);
        Pair currPair = new Pair(val, currMin);
        st.push(currPair);
    }
    
    public void pop() {
        st.pop();
        if(st.isEmpty()) currMin = Integer.MAX_VALUE;
        else currMin = st.peek().getValue();
    }
    
    public int top() {
        return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue();
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