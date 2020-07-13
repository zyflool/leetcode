package com.zyflool.kotlin

import kotlin.math.min

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

fun main(args: Array<String>) {
    val triangle = ArrayList<ArrayList<Int>>()
    val l1 = ArrayList<Int>()
    val l2 = ArrayList<Int>()
    val l3 = ArrayList<Int>()
    val l4 = ArrayList<Int>()

    l1.add(2)
    l2.add(3)
    l2.add(4)
    l3.add(6)
    l3.add(5)
    l3.add(7)
    l4.add(4)
    l4.add(1)
    l4.add(8)
    l4.add(3)

    triangle.add(l1)
    triangle.add(l2)
    triangle.add(l3)
    triangle.add(l4)

    println(minimumTotal(triangle))
}

fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty())
        return 0
    if ( triangle.size == 1 )
        return triangle[0][0]

    val dp = Array(triangle.size){0}

    for ( i in triangle.indices ) {
        for ( j in  triangle[i].size-1 downTo  0 ) {
            when (j) {
                0 -> dp[j] = dp[0] + triangle[i][0]
                triangle[i].size-1 -> dp[j] = dp[j-1] + triangle[i][triangle[i].size-1]
                else -> dp[j] = min(dp[j-1], dp[j]) + triangle[i][j]
            }
        }
    }

    var min = Int.MAX_VALUE

    for ( i in triangle.indices )
        min = min(dp[i], min)

    return min
}
