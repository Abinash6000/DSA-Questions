class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = nums[0];

        for(int i = 1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); // if not taking current, take max of both
            dp[i][1] = dp[i-1][0] + nums[i]; 

        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public int dp(int[] nums, int i, boolean robbedAdj) { // top-down
        if(i < 0) return 0;

        int res1 = Integer.MIN_VALUE;
        // rob
        if(!robbedAdj)
            res1 = dp(nums, i-1, true) + nums[i];
        // don't rob
        int res2 = dp(nums, i-1, false);

        return Math.max(res1, res2);
    }
}