```java
// Time Complexity: O(nlogk2)
// Space Complexity: O(k2)
class Solution { 
    public static long sumBetweenTwoKth(long A[], long N, long k1, long k2)
    {
        // Your code goes here
        if(N == 1) return 0;
        if(k1 >= k2) return 0;
        
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        for(long ele : A) {
            maxHeap.add(ele);
            if(maxHeap.size() > k2) maxHeap.remove();
        }
        
        long k2thSmall = maxHeap.remove();
        
        while(maxHeap.size() > k1) {
            maxHeap.remove();
        }
        
        long k1thSmall = maxHeap.remove();
        
        int sum = 0;
        for(long ele : A) {
            if(ele < k2thSmall && ele > k1thSmall) {
                sum += ele;
            }
        }
        
        return sum;
    }
    
}
```
