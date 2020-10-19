package com.zyflool.kotlin

/*
191. 位1的个数
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

示例 1：
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

示例 2：
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。

示例 3：
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

提示：
请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。

进阶:
如果多次调用这个函数，你将如何优化你的算法？
 */


fun main(args: Array<String>) {
    println(hammingWeight(13))
}
/**
 * 不再检查数字的每一个位，而是不断把数字最后一个 1 反转，并把答案加一。
 * 当数字变成 0 的时候偶，我们就知道它没有 1 的位了，此时返回答案。
 *
 * 这里关键的想法是对于任意数字 n ，将 n 和 n−1 做与运算，会把最后一个 1 的位变成 0 。
 * 为什么？考虑 n 和 n−1 的二进制表示。
 * 在二进制表示中，数字 n 中最低位的 1 总是对应 n−1 中的 0 。因此，将 n 和 n−1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
 */
fun hammingWeight(n:Int):Int {
    var sum = 0
    var m = n
    while (m != 0) {
        sum++
        m = m.and(m-1)
    }
    return sum
}
//
//fun hammingWeight(n:Int):Int {
//    var bits = 0
//    var mask = 1
//    for ( i in 0..31) {
//        if ( n.and(mask) != 0)
//            bits++
//        mask = mask.shl(1)
//    }
//    return bits
//}