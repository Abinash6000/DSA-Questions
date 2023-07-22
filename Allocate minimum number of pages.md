## Time Complexity: O(nlogn)
## Space Complexity: O(1)

```java
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[] a,int n,int m)
    {
        if(m > n) return -1;
        //Your code here
        int sum = 0;
        for(int ele : a) sum += ele;
        int low = a[n-1], high = sum, res = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(isValid(a, n, m, mid)) {
                res = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return res;
    }
    
    private static boolean isValid(int[] a, int n, int m, int mid) {
        int count = 1, sum = 0;
            
            for(int i = 0; i<n; i++) {
                sum += a[i];
                
                if(sum > mid) {
                    count++;
                    sum = a[i];
                }
            }
            
            return count <= m;
    }
};
```
