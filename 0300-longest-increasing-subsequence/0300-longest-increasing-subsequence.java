class Solution {
    int[][] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(nums, -1, 0);
    }

    private int helper(int[] nums, int prev_i, int i) {
        // base case: reached end
        if (i == nums.length) return 0;

        // check memo
        if (memo[prev_i + 1][i] != -1) return memo[prev_i + 1][i];

        // option 1: skip current element
        int notTake = helper(nums, prev_i, i + 1);

        // option 2: take current element (if valid)
        int take = 0;
        if (prev_i == -1 || nums[i] > nums[prev_i]) {
            take = 1 + helper(nums, i, i + 1);
        }

        // store result
        memo[prev_i + 1][i] = Math.max(take, notTake);
        return memo[prev_i + 1][i];
    }
}
