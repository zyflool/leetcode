package com.zyflool.kotlin

import javax.print.attribute.IntegerSyntax
import kotlin.math.max

/*
188. 买卖股票的最佳时机 IV
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

示例 2:
输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
/**
 * 系列股票问题：121、122、123、124、188、309、714
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 */

fun main(args: Array<String>) {
    println(maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3)))
}

fun maxProfit(k: Int, prices: IntArray): Int {
    /**
     * dp[i][k][j]到第i天 第k笔交易 状态j下 能获得第最大收益
     * 状态： 1 / 0   持有股票/没有股票
     *
     * dp[i][k][1] = max(dp[i-1][k][0], dp[i-1][k-1][1]-prices[i])
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *
     * 初始状态：
     * dp[0][1..k][0] = 0
     * dp[0][1..k][1] = -prices[0]
     * dp[1 until n][0][0] = 0
     * dp[1 until n][0][1] = MIN_VALUE
     *
     */
    if (prices.size < 2)
        return 0
    if (k > prices.size / 2) {
        val dp = Array(prices.size) { IntArray(2) }
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for (i in 1 until prices.size) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }
        return dp[prices.size - 1][0]
    } else {
        val dp = Array(prices.size) { Array(k + 1) { IntArray(2) } }
        for (j in 1..k) {
            dp[0][j][1] = -prices[0]
        }
        for (i in 1 until prices.size) {
            for (j in 1..k) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
            }
        }
        return dp[prices.size - 1][k][0]
    }
}