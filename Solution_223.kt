package com.zyflool.kotlin

/*
223. 矩形面积
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
每个矩形由其左下顶点和右上顶点坐标表示，如图所示。

示例:
输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
说明: 假设矩形面积不会超出 int 的范围。
 */

fun main() {
    println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
}

fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
    var l = 0
    var h = 0
    val xRange1 = A..C
    val xRange2 = E..G
    val yRange1 = B..D
    val yRange2 = F..H

    l = if (E in xRange1) {
        if (G in xRange1)
            xRange2.last - xRange2.first
        else
            C - E
    } else if (G in xRange1)
        G - A
    else if (G > C && E < A)
        xRange1.last - xRange1.first
    else 0

    h = if (F in yRange1) {
        if (H in yRange1)
            yRange2.last - yRange2.first
        else
            D - F
    } else if (H in yRange1)
        H - B
    else if (F < B && H > D)
        yRange1.last - yRange1.first
    else 0

    return (C - A) * (D - B) + (G - E) * (H - F) - l * h
}