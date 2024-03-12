class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for(int i = 0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            if(i != prices.length-1 && prices[i+1] > prices[i]) continue;
            profit = Math.max(profit, prices[i]-min);
        }

        return profit;
    }
}