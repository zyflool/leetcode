package com.zyflool.kotlin

/*
219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引i和j，使得 nums[i] = nums[j]，并且i和j的差的绝对值至多为k。

示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true

示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true

示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false

[1,2,3,4,5,6,7,8,9,9]
3
*/

fun main(args: Array<String>) {
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 9), 3))
}

//滑动窗口
//fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
//    if (nums.isEmpty() || nums.size == 1 || k == 0)
//        return false
//    var left = 0
//    var right = 1
//    while (left < right && right < nums.size) {
//        println("[$left, $right]")
//        if (nums[left] == nums[right])
//            return true
//        if (right - left == k||right == nums.size-1) {
//            left++
//            right = left + 1
//        } else
//            right++
//    }
//    return false
//}

//把k区间的所有数保存到集合里
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    for (i in nums.indices) {
        if (i > k) {
            set.remove(nums[i - k - 1])
        }
        if (!set.add(nums[i])) {
            return true
        }
    }
    return false
}