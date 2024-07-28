class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int st = 1, ed = n-2, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
                return mid;
            else if (nums[mid-1] < nums[mid]) // peak on right
                st = mid+1;
            else // peak on left
                ed = mid-1;
        }

        return -1;
    }
}