class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        boolean brked = false;
        for(int i = 1; i<n; i++) {
            if(brked && nums[i] < nums[i-1]) return false;
            if(nums[i] < nums[i-1]) brked = true;
        }

        if(brked && nums[0] < nums[n-1]) return false;

        return true;
    }
}