package com.zyflool.kotlin
/*
153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。

示例 1:
输入: [3,4,5,1,2]
输出: 1

示例 2:
输入: [4,5,6,7,0,1,2]
输出: 0
 */
/**
 * 二分查找
 * 拐点左侧都大于第一个数据
 * 拐点右侧都小于第一个数据
 */
fun main(args: Array<String>) {
    println(findMin(arrayOf(3,4,5,1).toIntArray()))
}

fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while ( l < r ) {
        val m = ( l + r ) / 2
        if ( nums[m] > nums[r] )
            l = m + 1
        else
            r = m
    }
    return nums[l]
}