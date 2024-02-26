class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        int m = l + (r - l) / 2, ml = 0, mr = 0;
        int lmax = maxSubArray(nums, l, m - 1);
        int rmax = maxSubArray(nums, m + 1, r);
        for (int i = m - 1, sum = 0; i >= l; i--) {
            sum += nums[i];
            ml = Math.max(sum, ml);
        }
        for (int i = m + 1, sum = 0; i <= r; i++) {
            sum += nums[i];
            mr = Math.max(sum, mr);
        }
        return Math.max(Math.max(lmax, rmax), ml + mr + nums[m]);
    }
}