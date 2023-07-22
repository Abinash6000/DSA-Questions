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

/*
Q -> I have a doubt why is there no condition for students <k?? Even this condition should return false right?

Ans -> ​Actually this condition should return "true" because if students < k that means we have distributed some extra books to a particular student, in that case we can take the extra book from that particular student and give it to a new student until the condition becomes students == k.

This condition is already handled in isValid() function when we return true at the end of function.
For example:- consider the following testcase:
n = 7 array = 15 10 19 10 5 18 7 k = 5

distribution for max = 25: [[15, 10], [19], [10, 5], [18, 7]] : no. of students == 4. But, we can easily take one book from a student and give it to a new student which will give us a no. of students == 5. In this case the function will return true.
Thank You.
*/
```
