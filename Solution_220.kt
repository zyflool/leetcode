package com.zyflool.kotlin

import java.util.*

/*
220. 存在重复元素 III
在整数数组 nums 中，是否存在两个下标i和j，使得 nums[i] 和 nums[j] 的差的绝对值小于等于 t ，且满足i和j的差的绝对值也小于等于 ķ 。
如果存在则返回 true，不存在返回 false。

示例 1:
输入: nums = [1,2,3,1], k = 3, t = 0
输出: true

示例 2:
输入: nums = [1,0,1,1], k = 1, t = 2
输出: true

示例 3:
输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false
*/

fun main(args: Array<String>) {
    println(containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5,), 2, 3))
}

//滑动窗口
//fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
//    if (nums.isEmpty() || nums.size == 1 || k == 0)
//        return false
//    var left = 0
//    var right = 1
//    while (left < right && right < nums.size) {
//        println("[$left, $right]")
//        if (Math.abs(nums[left].toLong() - nums[right].toLong()) <= t)
//            return true
//        if (right - left == k || right == nums.size - 1) {
//            left++
//            right = left + 1
//        } else
//            right++
//    }
//    return false
//}

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    val record = TreeSet<Long>() //保存当前值
    for (i in 0 until nums.size) {
        val l = record.ceiling(nums[i].toLong() - t.toLong()) //返回大于等于此值的最小值
        if (l != null && l <= nums[i] + t)
            return true
        val r = record.floor(nums[i].toLong() + t.toLong()) //返回小于等于此值的最大值
        if (r != null && r >= nums[i].toLong() - t.toLong())
            return true
        record.add(nums[i].toLong())
        if (record.size == k + 1) { //维护k区间上的集合
            record.remove(nums[i - k].toLong())
        }
    }
    return false
}