package com.zyflool.kotlin

/*
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:
输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

示例 2:
输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。*/
/**
 * 字典树 + 深度优先遍历 + 回溯 + 剪枝
 */

fun main(args: Array<String>) {
    val nums = intArrayOf(2, 3, 2)
    println(rob(nums))
}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    if (nums.size == 2) return Math.max(nums[0], nums[1])
    val dp1 = Array(nums.size) { IntArray(2) }//0--(n-2)
    val dp2 = Array(nums.size) { IntArray(2) }//1--n-1

    dp1[0][0] = 0
    dp1[0][1] = nums[0]

    dp2[1][0] = 0
    dp2[1][1] = nums[1]

    for (i in nums.indices) {
        when (i) {
            0 -> {
                dp1[i][0] = 0
                dp1[i][1] = nums[0]
            }
            1 -> {
                dp2[i][0] = 0
                dp2[i][1] = nums[1]

                dp1[i][0] = Math.max(dp1[i - 1][1], dp1[i - 1][0])
                dp1[i][1] = dp1[i - 1][0] + nums[i]
            }
            nums.size - 1 -> {
                dp2[i][0] = Math.max(dp2[i - 1][1], dp2[i - 1][0])
                dp2[i][1] = dp2[i - 1][0] + nums[i]
            }
            else -> {
                dp1[i][0] = Math.max(dp1[i - 1][1], dp1[i - 1][0])
                dp1[i][1] = dp1[i - 1][0] + nums[i]
                dp2[i][0] = Math.max(dp2[i - 1][1], dp2[i - 1][0])
                dp2[i][1] = dp2[i - 1][0] + nums[i]
            }
        }
    }
    val max1 = Math.max(dp1[nums.size - 2][0], dp1[nums.size - 2][1])
    val max2 = Math.max(dp2[nums.size - 1][0], dp2[nums.size - 1][1])

    return Math.max(max1, max2)
}