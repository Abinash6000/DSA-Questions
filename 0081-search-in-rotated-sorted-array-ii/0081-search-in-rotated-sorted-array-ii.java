class Solution {
    public boolean search(int[] nums, int target) {
        int st = 0, ed = nums.length-1, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] == nums[st] && nums[st] == nums[ed]) { // because in this question all 3 can be equal
                // if that happens then our condition to check which side of middle is sorted, becomes wrong
                // then we simply shrink the search space, which will get us a to point when all 3 are not equal
                st++;
                ed--;
            }
            else if(nums[st] <= nums[mid]) // left side is sorted
                if(nums[st] <= target && target < nums[mid]) // target is on left side
                    ed = mid-1;
                else // target is on right side
                    st = mid+1;
            else // right side is sorted
                if(nums[mid] < target && target <= nums[ed]) // target is on right side
                    st = mid+1;
                else // target is on left side
                    ed = mid-1;
        }
        return false;
    }
}