package com.zyflool.kotlin

/*
168. Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"
 */

fun main(args: Array<String>) {
    println(convertToTitle(703))
}

fun convertToTitle(n: Int): String {
    var m = n
    val res = StringBuilder()
    while ( m != 0 ) {
        println(m)
        res.append('A'+ (m-1)%26)
        m = (m-1)/26
    }
    return res.reverse().toString()
}