## Time Complexity: $$O(logn)$$
## Space Complexity: $$O(1)$$

# Code 
```java
public class Solution {
    public int solve(int[] A, int B) {
        int low = 0, high = A.length-1;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(A[mid] > A[mid+1]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        return Math.max(binarySearch(0, low, A, B, true), binarySearch(low, A.length-1, A, B, false));
    }
    
    private int binarySearch(int low, int high, int[] arr, int key, boolean incr) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == key) return mid;
            else if(arr[mid] > key) {
                if(incr) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            else {
                if(incr) {
                    low = mid+1;
                } else {
                    high = mid -1;
                }
            }
        }
        
        return -1;
    }
}

```
