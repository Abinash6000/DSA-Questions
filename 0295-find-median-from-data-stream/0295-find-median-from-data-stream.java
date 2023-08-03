class MedianFinder {

    private PriorityQueue<Integer> large = new PriorityQueue<>(); // holds large elements
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // holds small elements
    boolean even = true;
    
    public void addNum(int num) {
        if(even) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }

        even = !even;
    }
    
    public double findMedian() {
        if(even) 
            return (small.peek() + large.peek()) / 2.0;
        else 
            return large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */