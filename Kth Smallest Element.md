```java
// Time Complexity: O(nlogk)
// Space Complexity: O(k)

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(; l <= r; l++) {
            
            pq.add(arr[l]);
            if(pq.size() > k) pq.remove();
        
        }
        
        return pq.remove();
    } 
}

```
