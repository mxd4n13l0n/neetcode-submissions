class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = 101
        var maxProfit = 0
        for (i in 0..prices.lastIndex - 1) {
            min = Math.min(min, prices[i])
            val profit = prices[i + 1] - min
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }
}
