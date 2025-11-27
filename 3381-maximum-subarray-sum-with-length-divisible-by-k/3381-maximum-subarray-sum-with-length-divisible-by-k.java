long maxSubarraySum(int[] nums, int k) {
    // Build prefix sum array
    long[] ps = new long[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        ps[i + 1] = ps[i] + nums[i];
    }

    long res = Long.MIN_VALUE;

    // Try all offsets modulo k
    for (int p = 0; p < k; p++) {
        long sum = 0;

        for (int i = p; i + k <= nums.length; i += k) {
            long n = ps[i + k] - ps[i]; // sum of block [i, i+k)
            sum = Math.max(n, sum + n);
            res = Math.max(res, sum);
        }
    }

    return res;
}
