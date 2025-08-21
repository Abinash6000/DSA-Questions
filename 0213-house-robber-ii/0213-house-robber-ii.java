class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];  // edge case: only one house

        return Math.max(robLinear(nums, 0, n-2), robLinear(nums, 1, n-1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev0 = 0, prev1 = 0;  // prev0 = max if not taking prev, prev1 = max if taking prev
        for(int i = start; i <= end; i++) {
            int temp = prev0;
            prev0 = Math.max(prev0, prev1);  // skip current
            prev1 = temp + nums[i];          // take current
        }
        return Math.max(prev0, prev1);
    }
}
