class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1] || n == 1) return nums[0];

        int st = 0, ed = n-1, min = 5001, mid;
        
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[st] < nums[mid]) {// left side sorted, take min from left side
                min = Math.min(min, nums[st]);
                st = mid+1;
            } else { // right side sorted, take min from right side
                min = Math.min(min, nums[mid]);
                ed = mid-1;
            }
        }

        return min;
    }
}