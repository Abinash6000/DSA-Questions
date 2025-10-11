class Solution {
    int memo[];
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length+1];
        return helper(nums, -1, 0);
    }

    private int helper(int[] nums, int prev_i, int i) {
        if(i == nums.length) return 0;
        if(memo[prev_i+1] != 0) return memo[prev_i+1];

        int ss1 = 0;

        if(prev_i == -1 || nums[i] > nums[prev_i])
            ss1 = 1 + helper(nums, i, i+1); // select
        
        int ss2 = helper(nums, prev_i, i+1); // not select

        return memo[prev_i+1] = Math.max(ss1, ss2);
    }
}