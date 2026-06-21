class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var res = 0

        for(price in prices) {
            if(price < min) min = price
            else res = max(res, price-min)
        }

        return res
    }
}