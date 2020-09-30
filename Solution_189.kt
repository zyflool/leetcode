package com.zyflool.kotlin
/*
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

说明:
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */

fun main(args: Array<String>) {
    var nums = intArrayOf(-1)
    println(nums.joinToString())
    println(rotate(nums, 2))
    println(nums.joinToString())
}

/**
 * 暴力便利 一次移动一位
 */
//fun rotate(nums: IntArray, k: Int): Unit {
//    val n = k % nums.size
//    for (i in 1..n) {
//        var t = nums[0]
//        for ( j in nums.indices ) {
//            if ( j < nums.size - 1 ) {
//                val  temp = nums[j+1]
//                nums[j+1] = t
//                t = temp
//            }
//        }
//        nums[0] = t
//    }
//}

/**
 * 完全反转数组
 * 然后分成两组（从后面移动到前面的，从前面移动到后面的）再分别反转
 */
//fun rotate(nums: IntArray, k: Int): Unit {
//    val n =  k % nums.size
//    if ( n == 0 )
//        return
//    for (i in 0..(nums.size-1)/2) {
//        val t = nums[i]
//        nums[i] = nums[nums.size-1-i]
//        nums[nums.size-1-i] = t
//    }
//    for ( i in 0..(n-1)/2 ) {
//        val t = nums[i]
//        nums[i] = nums[n-1-i]
//        nums[n-1-i] = t
//    }
//    for ( i in n..(nums.size-1+n)/2 ) {
//        val t = nums[i]
//        nums[i] = nums[nums.size+n-1-i]
//        nums[nums.size+n-1-i] = t
//    }
//}

/**
 * 环状替代，一个挤一个直到回到开始点，然后继续换下一个，直到所有的位置都被换过。
 */
fun rotate(nums: IntArray, k: Int): Unit {
    val n = k % nums.size
    var count = 0
    for (start in 0..Int.MAX_VALUE) {
        if (count >= nums.size)
            break
        var cur = start
        var pre = nums[cur]
        do {
            val next = (cur + n) % nums.size
            val temp = nums[next]
            nums[next] = pre
            pre = temp
            cur = next
            count++
        } while (start != cur)
    }
}