package com.zyflool.kotlin
/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

fun main(args: Array<String>) {
    println(maxProduct(arrayOf(2,3,-2,4).toIntArray()))
}

fun maxProduct(nums: IntArray): Int {
    val numLength = nums.size

    if (numLength == 0)
        return 0

    // dp[i][0] with min and dp[i][1] with max
    val dp = Array(numLength) {IntArray(2)}
    dp[0][0] = nums[0]
    dp[0][1] = nums[0]

    for (i in 1 until numLength) {
        if (nums[i] >= 0) {
            dp[i][0] = (dp[i - 1][0] * nums[i]).coerceAtMost(nums[i])
            dp[i][1] = (dp[i - 1][1] * nums[i]).coerceAtLeast(nums[i])
        } else {
            dp[i][0] = (dp[i - 1][1] * nums[i]).coerceAtMost(nums[i])
            dp[i][1] = (dp[i - 1][0] * nums[i]).coerceAtLeast(nums[i])
        }
    }
    var res = dp[0][1]
    for (i in 1 until numLength)
        res = res.coerceAtLeast(dp[i][1])

    return res
}