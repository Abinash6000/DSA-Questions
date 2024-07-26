class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        int st = 0, ed = nums.length-1, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > nums[0] && target > nums[0]) {
                if(target > nums[mid]) {
                    st = mid+1;
                } else if(target < nums[mid]) {
                    ed = mid-1;
                }
            } else if(nums[mid] < nums[0] && target < nums[0]) {
                if(target > nums[mid]) {
                    st = mid+1;
                } else if(target < nums[mid]) {
                    ed = mid-1;
                }
            } else if(nums[mid] < nums[0] && target > nums[0]) {
                ed = mid-1;
            } else if(nums[mid] > nums[0] && target < nums[0]) {
                st = mid+1;
            } else if(nums[mid] == nums[0]) st = mid+1;
        }

        return -1;
    }
}