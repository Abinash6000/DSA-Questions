class Solution {
    public static long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n + 1][k + 1][3];

        for (int K = 0; K <= k; K++) {
            dp[n][K][0] = 0; 
            dp[n][K][1] = Integer.MIN_VALUE;
            dp[n][K][2] = Integer.MIN_VALUE;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int K = 0; K <= k; K++) {
                for (int decider = 0; decider < 3; decider++) {
                    long take = Integer.MIN_VALUE;
                    long dontTake = dp[i + 1][K][decider];

                    if (K > 0) {
                        if (decider == 1) {
                            take = prices[i] + dp[i + 1][K - 1][0];
                        } else if (decider == 2) {
                            take = -prices[i] + dp[i + 1][K - 1][0];
                        } else {
                            take = Math.max(
                                prices[i] + dp[i + 1][K][2],
                                -prices[i] + dp[i + 1][K][1]
                            );
                        }
                    }

                    dp[i][K][decider] = Math.max(take, dontTake);
                }
            }
        }

        return dp[0][k][0];
    }
}