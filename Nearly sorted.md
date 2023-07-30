```java
// Time Complexity: O(nlogk)
// Space Complexity: O(n)
class Solution
{
    ArrayList<Integer> nearlySorted(int arr[], int n, int k)
    {
        ArrayList<Integer> sortedAL = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size() > k) sortedAL.add(minHeap.remove());
        }
        
        while(minHeap.size() > 0) sortedAL.add(minHeap.remove());
        
        return sortedAL;
    }
}
```
