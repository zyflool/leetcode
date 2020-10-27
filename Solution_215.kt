package com.zyflool.kotlin

import java.util.*

/*
215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/

fun main(args: Array<String>) {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4),2))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    val random = Random(1602327070551)
    var topK = 0
    fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (end < start) {
            return
        }
        nums.swap(random.nextInt(end - start + 1) + start, start)
        val flag = nums[start]
        var left = start
        var right = end
        while (left != right) {
            while (right > left && nums[right] >= flag) {
                right--
            }
            while (right > left && nums[left] <= flag) {
                left++
            }
            if (right > left)
                nums.swap(left, right)
        }
        nums.swap(start, left)
        val exp = nums.size - k
        when {
            left == exp -> {
                topK = nums[left]
                return
            }
            left < exp -> {
                quickSort(nums, left + 1, end)
            }
            else -> {
                quickSort(nums, start, left - 1)
            }
        }
    }
    quickSort(nums, 0, nums.size - 1)
    return topK
}