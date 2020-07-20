package com.zyflool.kotlin
/*
164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。

示例 1:
输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。

示例 2:
输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。

说明:
你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */

/**
 * 基数排序
 */

fun main(args: Array<String>) {
    println(maximumGap(arrayOf(1,2,3,4,5,6,7,8,9,20,100,2030,49592,6039596,23444,34).toIntArray()))
}

fun maximumGap(nums: IntArray): Int {
    if ( nums.size < 2 )
        return 0
    radixSort(nums, 10)

    var maxGap = Int.MIN_VALUE

    for ( i in 1 until nums.size)
        maxGap = (nums[i]- nums[i-1]).coerceAtLeast(maxGap)

    return maxGap
}

fun radixSort(nums: IntArray, Base: Int) {
    var max: Int = Int.MIN_VALUE
    var times = 1

    for ( i in nums )
        max = i.coerceAtLeast(max)

    while ( max / times > 0 ) {

        var bucket = IntArray(Base){0}

        for ( e in nums )
            bucket[ (e / times) % Base ]++

        for ( i in 1 until Base )
            bucket[i] += bucket[i-1]

        val temp = IntArray(nums.size){0}
        for ( i in nums.size-1 downTo 0)
            temp[--bucket[(nums[i] / times) % Base]] =  nums[i]

        for ( i in nums.indices )
            nums[i] = temp[i]

        times *= Base
    }
}
