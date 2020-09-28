package com.zyflool.kotlin

import java.util.*

/*
179. 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:
输入: [10,2]
输出: 210

示例 2:
输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

fun main(args: Array<String>) {
    println(largestNumber(intArrayOf(10,2)))
}

/**
 * 自定义一种排序算法，使得对于任意的i>j，n[i]+n[j] > n[j]+n[j] (+号表示连接)
 *
 * 证明：传递性
 * 若s1>s2 s2>s3 则s1>s3
 * 设三个数分别为n1,n2,n3,三个数的位数分别为l1,l2,l3
 * 因为s1>s2,s2>s3,则：
 *      n1*l2+n2 > n2*l1+n1
 *      n2*l3+n3 > n3*l2+n2
 * 整理得：
 *      n1(l2-1) > n2(l1-1)     (1)
 *      n2(l3-1) > n3(l2-1)     (2)
 * 当l1 = 1时：
 *      l2>1
 * 当l2 = 1时
 * (1)(2)合并得到： n1n2(l2-1)(l3-1) > n2n3(l1-1)(l2-1)
 *
 * 若n2 == 0, 则n3=0, n1>0, s1>s3
 * 若n2 != 0, 则两遍同时除以n2(l2-1)得到：
 *       n1(l3-1) > n3(l1-1)
 * 即s1>s3
 */

fun largestNumber(nums: IntArray): String {
    val numbers = Array(nums.size) {
        nums[it].toString()
    }

    Arrays.sort(numbers,kotlin.Comparator<String> { s1, s2 ->
        return@Comparator(s2+s1).compareTo(s1+s2)
    })

    return if (numbers[0] == "0") "0" else numbers.joinToString(separator = "") { it }
}