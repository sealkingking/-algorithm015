package wu.seal.algorithms.leetcode

/**
 *  Created by Seal.Wu(wuhaibao) on 2020/9/17
 *  Description:
 */
class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var sum = 0
        for (i in 1 until prices.size) {
            if (prices[i - 1] < prices[i]) sum += prices[i] - prices[i - 1]
        }
        return sum
    }
}
