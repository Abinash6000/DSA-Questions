class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int st = 0, ed = n-1;
        if(nums[0] <= nums[n-1]) return nums[0];

        while(st <= ed) {
            int mid = st + (ed-st)/2;
            if(nums[0] > nums[mid]) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

        return nums[ed+1];
    }
}