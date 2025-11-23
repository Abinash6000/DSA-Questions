class Solution {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];

        int mod = nums[0] % 3;
        if (mod == 0) dp[0][0] = nums[0];
        else if (mod == 1) dp[0][1] = nums[0];
        else dp[0][2] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1].clone();

            int x = dp[i - 1][0] + nums[i];
            int y = dp[i - 1][1] + nums[i];
            int z = dp[i - 1][2] + nums[i];

            dp[i][x % 3] = Math.max(dp[i][x % 3], x);
            dp[i][y % 3] = Math.max(dp[i][y % 3], y);
            dp[i][z % 3] = Math.max(dp[i][z % 3], z);
        }

        return dp[n - 1][0];
    }
}
