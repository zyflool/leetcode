package com.zyflool.kotlin

import kotlin.math.abs

/*
166. 分数到小数
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:
输入: numerator = 1, denominator = 2
输出: "0.5"

示例 2:
输入: numerator = 2, denominator = 1
输出: "2"

示例 3:
输入: numerator = 2, denominator = 3
输出: "0.(6)"
 */

/**
 * 哈希表
 * 使用长除法，当被除数出现对应的小数位时表示开始循环并且通过当前位和此前记录的小数位可以确定循环节的范围
 */

fun main(args: Array<String>) {
    println(fractionToDecimal(11,535500))
}

fun fractionToDecimal(numerator: Int, denominator: Int): String {
    val sign = if (numerator.toFloat() / denominator >= 0) "" else "-"
    val numeratorP = abs(numerator.toLong())
    val denominatorP = abs(denominator.toLong())

    if (numeratorP % denominatorP == 0L) {
        return "$sign${numeratorP / denominatorP}"
    }

    val decimals = StringBuilder()
    val numIndex = mutableMapOf<Long, Int>()
    var num = (numeratorP % denominatorP) * 10
    while (num != 0L) {
        numIndex[num]?.let { index ->
            val allDecimals = decimals.toString()
            return "$sign${numeratorP / denominatorP}.${allDecimals.substring(0, index)}(${allDecimals.substring(index)})"
        }
        numIndex[num] = decimals.length
        decimals.append(num / denominatorP)
        num = (num % denominatorP) * 10
    }
    return "$sign${numeratorP / denominatorP}.${decimals}"
}
