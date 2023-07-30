# Code
```java
// Time Complexity: O(nlogk) (Follow up: which is less than O(nlogn))
// Space Complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) { // O(n)
            minHeap.add(entry); 
            if(minHeap.size() > k) minHeap.remove(); // O(logk)
        }

        int[] arr = new int[k];
        while(!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.remove();
            arr[minHeap.size()] = entry.getKey();
        }

        return arr;
    }
}
```
