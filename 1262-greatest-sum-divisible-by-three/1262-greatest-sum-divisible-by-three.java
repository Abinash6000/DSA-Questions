class Solution {

    private int solve(int i, int[] nums, int r, int[][] dp) {
        if (i == nums.length) {
            return r == 0 ? 0 : -1000000;
        }

        if (dp[i][r] != -1) {
            return dp[i][r];
        }

        int take = nums[i] + solve(i + 1, nums, (r + nums[i]) % 3, dp);
        int skip = solve(i + 1, nums, r, dp);

        return dp[i][r] = Math.max(take, skip);
    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, nums, 0, dp);
    }
}
