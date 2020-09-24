package com.zyflool.kotlin
/*
172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。
 */

/**
 * 每出现多一个5 就多一个零
 * ...5...2*5...3*5...4*5...5*5...6*5...
 * 每5个数就会多一个0
 * 每25个数就会多两个0
 * 每125个数就会多三个0
 * ...
 * 最终5的个数就是n/5+n/25+n/125....
 */
fun main(args: Array<String>) {
    println(trailingZeroes(5))
}

fun trailingZeroes(n: Int): Int {
    var count = 0
    var m = n
    while (m > 0) {
        count += m/5
        m /= 5
    }
    return count
}