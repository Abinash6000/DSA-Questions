class MyStack {
    
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        if(queue.size() == 0) return -1;
        int i = 1;
        while(i++ < queue.size()) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
    
    public int top() {
        if(queue.size() == 0) return -1;
        int i = 1;
        while(i++ < queue.size()) {
            queue.offer(queue.poll());
        }
        int res = queue.peek();
        queue.offer(queue.poll());
        return res;
    }
    
    public boolean empty() {
        if(queue.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */