class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] preProfit = new long[n+1];
        long[] preSum = new long[n+1];

        long orig = 0;
        for(int i = 0; i<n; i++) {
            orig += (long) strategy[i]*prices[i];
            preProfit[i+1] = preProfit[i] + (long) strategy[i]*prices[i];
            preSum[i+1] = preSum[i] + prices[i];
        }

        long maxDelta = Long.MIN_VALUE;
        int half = k/2;

        for(int i = 0; i+k<=n; i++) {
            // first half -> set to 0
            long oldFirst = preProfit[i+half] - preProfit[i];
            long newFirst = 0;

            // second half -> set to 1
            long oldSecond = preProfit[i+k] - preProfit[i+half];
            long newSecond = preSum[i+k] - preSum[i+half];

            long delta = (newFirst - oldFirst) + (newSecond - oldSecond);
            maxDelta = Math.max(maxDelta, delta);
        }

        return orig + Math.max(0, maxDelta);
    }
}