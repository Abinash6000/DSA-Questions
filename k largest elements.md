```java
// Time Complexity: O(k + nlogk)
// Space Complexity: O(k)

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size() > k) minHeap.remove();
        }
        
        int[] ans = new int[k];
        while(minHeap.size() > 0) {
            ans[minHeap.size()-1] = minHeap.remove();
        }
        
        return ans;
    }
}
```
