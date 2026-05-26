// Striver Solution (the right way)
// knowing atleast one side of the mid will be fully sorted
// if the target is in the sorted side, move towards that or away from that if not there...

class Solution {
    public int search(int[] nums, int target) {
        int st = 0, ed = nums.length-1, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid] == target) return mid;
            else if(nums[st] <= nums[mid]) // left side is sorted
                if(target >= nums[st] && target < nums[mid]) // target is on left side
                    ed = mid-1;
                else // target is on right side
                    st = mid+1;
            else // right side is sorted
                if(target <= nums[ed] && target > nums[mid]) // target is on right side
                    st = mid+1;
                else // target is on left side
                    ed = mid-1;
        }

        return -1;
    }
}