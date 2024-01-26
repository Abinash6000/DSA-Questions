class Solution {
    int memo[][];
    public int coinChange(int[] coins, int amount) {
        memo = new int[10001][coins.length];
        int ans = solve(coins, amount, 0);
        return ans == 10001 ? -1 : ans;
    }

    private int solve(int[] coins, int amt, int i) {
        if(amt == 0) return 0;
        if(i == coins.length) return 10001;
        if(memo[amt][i] != 0) return memo[amt][i];

        if(coins[i] <= amt) {
            // two choices take/not take
            return memo[amt][i] = Math.min(1 + solve(coins, amt-coins[i], i), solve(coins, amt, i+1));
        } else {
            return memo[amt][i] = solve(coins, amt, i+1);
        }
    }
}