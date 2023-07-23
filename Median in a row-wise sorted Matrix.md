## Time Complexity: O(log(Integer.MAXIMUM_VALUE) * mlogn) = O(32*mlogn)
## Space complexity: O(1)

```java
class Solution {
    int median(int matrix[][], int R, int C) {
        // code here   
        int low = 1, high = Integer.MAX_VALUE, median = 0;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(isValid(mid, matrix)) {
                median = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return median;
    }
    
    boolean isValid(int potentMed, int[][] a) {
        // if potentMed is median then there will be exactly m*n/2 +1 elements which will be less than or equal to potentmed;
        int count = 0;
        for(int[] row : a) {
            int low  = 0, high = a[0].length-1; 
            
            while(low <= high) {
                int mid = low + (high - low)/2;
                
                if(row[mid] <= potentMed) low = mid+1;
                else high = mid-1;
            }
            // increase count at the end of each binary search
            count += (high+1);
        }
        
        // return according to if (count >= (a.length*a[0].length)/2 +1 ) return true;
        if(count >= ((a.length*a[0].length)/2 +1)) return true;
        else return false;
    }
}
```
