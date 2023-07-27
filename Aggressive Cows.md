## Time Complexity: O(nLogn + n*Log(max(stalls)))
## Space Complexity: O(1)
```java
// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[n-1], res = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(isValid(mid, k, stalls)) {
                res = Math.max(res, mid);
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return res;
    }
    
    private static boolean isValid(int minDist, int k, int[] stalls) {
        int sum = 0, count = 1;
        for(int i = 1; i < stalls.length; i++) {
            sum += stalls[i] - stalls[i-1];
            
            if(sum >= minDist) {
                count++;
                sum = 0;
            }
        }
        
        return count >= k;
    }
}
```
