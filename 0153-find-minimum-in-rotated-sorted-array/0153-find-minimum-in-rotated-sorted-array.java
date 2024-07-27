class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1] || n == 1) return nums[0];

        int st = 0, ed = n-1, mid;
        
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(mid != 0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[0] <= nums[mid]) // left side sorted
                st = mid+1;
            else // right side sorted
                ed = mid-1;
        }

        return -1;
    }
}