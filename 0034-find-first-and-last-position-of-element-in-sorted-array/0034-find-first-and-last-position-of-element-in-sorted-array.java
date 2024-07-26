class Solution {
    public int[] searchRange(int[] nums, int target) {

        int startPos = -1;
        int st = 0, ed = nums.length-1, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid] >= target) ed = mid-1;
            else st = mid+1;
        }
        startPos = ed != nums.length-1 && nums[ed+1] == target ? ed+1 : -1;

        int endPos = -1;
        st = 0; ed = nums.length-1;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid] <= target) st = mid+1;
            else ed = mid-1;
        }
        endPos = st != 0 && nums[st-1] == target ? st-1 : -1;

        return new int[]{startPos, endPos};
    }
}