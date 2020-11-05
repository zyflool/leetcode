package com.zyflool.kotlin

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
*/

fun main(args: Array<String>) {
    val matrix = Array<CharArray>(4){ charArrayOf('0')}
    matrix[0] = charArrayOf('1', '0', '1', '0', '0')
    matrix[1] = charArrayOf('1', '0', '1', '1', '1')
    matrix[2] = charArrayOf('1', '1', '1', '1', '1')
    matrix[3] = charArrayOf('1', '0', '0', '1', '0')
    println(maximalSquare(matrix))
}

fun maximalSquare(matrix: Array<CharArray>):Int {
    var maxSide = 0
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return maxSide
    }
    val rows = matrix.size
    val columns = matrix[0].size
    for (i in 0 until  rows) {
        for (j in 0 until columns) {
        if (matrix[i][j] == '1') {
            // 遇到一个 1 作为正方形的左上角
            maxSide = Math.max(maxSide, 1)
            // 计算可能的最大正方形边长
            var currentMaxSide = Math.min(rows - i, columns - j);
            for ( k in 1 until currentMaxSide) {
                // 判断新增的一行一列是否均为 1
                var flag = true
                if (matrix[i + k][j + k] == '0') {
                    break;
                }
                for (m in 0 until k) {
                if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                    flag = false
                    break
                }
            }
                if (flag) {
                    maxSide = Math.max(maxSide, k + 1)
                } else {
                    break
                }
            }
        }
    }
    }
    val maxSquare = maxSide * maxSide
    return maxSquare
}

