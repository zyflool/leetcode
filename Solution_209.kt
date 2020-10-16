package com.zyflool.kotlin

/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
如果不存在符合条件的子数组，返回 0。

示例：
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。

进阶：
如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
*/

fun main(args: Array<String>) {
    println(minSubArrayLen(3, intArrayOf(1,1)))
}

fun minSubArrayLen(s: Int, nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    var l = 0
    var r = 0
    var sum = nums[0]
    var res = Int.MAX_VALUE
    while (l <= r && r < nums.size) {
        if (sum >= s) {
           // println("($l, $r)")
            res = Math.min(res, r - l + 1)
            sum -= nums[l]
            l++
        } else {
            r++
            if (r < nums.size)
                sum += nums[r]
        }
    }
    if ( res == Int.MAX_VALUE )
        return 0
    return res
}
