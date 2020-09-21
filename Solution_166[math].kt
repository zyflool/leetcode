package com.zyflool.kotlin

import java.math.BigInteger

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
 * 数学方法判断循环小数的长度。
 * https://zh.wikipedia.org/wiki/%E5%BE%AA%E7%8E%AF%E5%B0%8F%E6%95%B0
 *
 * 对于 b / a
 * 1.除数 a = 2^m * 5^n * K 时，有max(m,n)个不循环位数，其中 K 为非2^m、5^n之外的其他数
 * 2.如果 1<=b<a，a不是2或5的倍数，并且a与b互质，那么存在一个正整数e，e 为 b/a 的循环节位数，而 e 是满足 10^e % a == 1 的最小自然数
 */

fun main(args: Array<String>) {
    println(fractionToDecimal(11,535500))
}

fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if ( numerator == 0 || denominator == 0 )
        return "0"
    if (numerator % denominator == 0 )
        return (numerator.toLong() / denominator.toLong()).toString()
    val flag = if ( numerator.toLong() * denominator.toLong() < 0 ) "-" else ""
    var numer = if (numerator < 0 ) 0L-numerator else 0L + numerator
    var denomin: Long = if (denominator < 0 ) 0L-denominator else 0L+denominator
    val n = if (numer > denomin) ( numer / denomin ).toInt() else 0

    numer -= n * denomin

    var m2 = 0
    var m5 = 0
    while (denomin % 2 == 0L) {
        m2++
        denomin /= 2
    }
    while (denomin % 5 == 0L) {
        m5++
        denomin /= 5
    }
    val nonrepeating = m2.coerceAtLeast(m5)

    var repeating: Long = 1
    var times = BigInteger("10")
    while ( !isDivisible(times.subtract(BigInteger("1")), denomin) && repeating < denomin) {
        times = times.multiply(BigInteger("10"))
        repeating++
    }
    repeating = if (repeating == denomin) 0 else repeating
    denomin = if (denominator < 0 ) 0L-denominator else 0L + denominator

    val decimal: String = if ( repeating + nonrepeating > 0) div(numer, denomin, nonrepeating, repeating.toInt()) else ""

    return "$flag$n$decimal"
}

fun isDivisible(divisor: BigInteger, dividend: Long): Boolean {
    val Dividend = BigInteger(dividend.toString())
    val res = divisor.divideAndRemainder(Dividend)
    return res[1].toString() == "0"
}

fun div(numer: Long, denomin: Long, nonrepeating: Int, repeating: Int): String{
    var temp = numer
    var res = StringBuilder(".")
    for ( i in 1..nonrepeating+repeating ) {
        if ( i == nonrepeating+1)
            res.append("(")
        res.append((temp * 10 / denomin).toString())
        temp = temp*10 - (temp*10/denomin)*denomin
    }
    when {
        repeating != 0 -> res.append(")")
        nonrepeating > 1 -> res = StringBuilder(res.toString() - '0')
    }
    return res.toString()
}

operator fun String.minus(other: Char):String {
    var t = this
    while (t[t.length-1] == other) {
        t = t.substring(0, t.length-1)
    }
    return t
}