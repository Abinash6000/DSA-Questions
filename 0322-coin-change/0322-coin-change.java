class Solution {
    int memo[][];
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i = 0; i<amount+1; i++) dp[i] = amount+1;
        dp[0] = 0;

        for(int a = 1; a<amount+1; a++) {
            for(int c : coins) {
                if(a>=c)
                    dp[a] = Math.min(dp[a], 1 + dp[a-c]);
            }
        }

        return  dp[amount] != amount+1 ? dp[amount] : -1;
    }

    // private int solve(int[] coins, int amt, int i) {
    //     if(amt == 0) return 0;
    //     if(i == coins.length) return 10001;
    //     if(memo[amt][i] != 0) return memo[amt][i];

    //     if(coins[i] <= amt) {
    //         // two choices take/not take
    //         return memo[amt][i] = Math.min(1 + solve(coins, amt-coins[i], i), solve(coins, amt, i+1));
    //     } else {
    //         return memo[amt][i] = solve(coins, amt, i+1);
    //     }
    // }
}