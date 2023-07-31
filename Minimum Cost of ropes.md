```java
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        for(long rope : arr) {
            minHeap.add(rope);
        }
        
        long totalCost = 0, currCost = 0;
        while(minHeap.size() > 1) {
            currCost = minHeap.remove() + minHeap.remove();
            totalCost += currCost;
            minHeap.add(currCost);
        }
        
        return totalCost;
    }
}
```
