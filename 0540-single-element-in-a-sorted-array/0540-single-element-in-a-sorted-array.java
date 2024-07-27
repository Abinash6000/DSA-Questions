class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int st = 1, ed = nums.length-2, mid = -1;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];
            else if(mid%2 != 0 && nums[mid-1] == nums[mid] ||
            mid%2 == 0 && nums[mid-1] != nums[mid]) // odd index, element on right
                st = mid+1;
            else // element on left
                ed = mid-1;
        }

        return nums[mid];
    }
}