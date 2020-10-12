package com.zyflool.kotlin

import kotlin.math.roundToInt

/*
204. 计数质数
统计所有小于非负整数 n 的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0

提示：
0 <= n <= 5 * 10^6
*/

fun main(args: Array<String>) {
    println(countPrimes(20))
}

fun countPrimes(n: Int): Int {
    if ( n <= 2 )
        return 0
    val set = HashSet<Int>()
    for ( i in 2 until n)
        set.add(i)
    val m = Math.sqrt(n*1.0).roundToInt()
    for ( i in 2..m) {
        if ( set.contains(i) ) {
            var times = 2
            while ( i * times < n) {
                set.remove(times * i)
                times++
            }
        }
    }
    return set.size
}