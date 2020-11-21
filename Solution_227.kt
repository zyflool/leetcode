package com.zyflool.kotlin

import java.util.*

/*
227. 基本计算器 II
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:
输入: "3+2*2"
输出: 7

示例 2:
输入: " 3/2 "
输出: 1

示例 3:
输入: " 3+5 / 2 "
输出: 5

说明：
你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
 */
fun main() {
    println(calculate(" 3+5 / 2 "))
}

fun calculate(s: String): Int {
    if (!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/")) {
        var s1 = s.replace(" ", "")
        return s1.toInt()
    }
    val notation = s.replace(" ", "").toMutableList()
    var i = 0

    while (i < notation.size) {
        if (notation[i] == '+' || notation[i] == '-' || notation[i] == '*' || notation[i] == '/') {
            if (i != notation.size - 1) {
                notation.add(i + 1, ' ')
                i += 2
            } else
                i++
            continue
        }
        while ((i + 1) < notation.size && notation[i + 1] in '0'..'9') {
            i++
        }
        if (i != notation.size - 1) {
            notation.add(i + 1, ' ')
            i += 2
        } else
            i++
    }
//    println(notation.joinToString(separator = ""))
//    println(convertInfixIntoPostfix(notation.joinToString(separator = "")))
    return calculateByPostfix(convertInfixIntoPostfix(notation.joinToString(separator = "")))

}

val operatorPriorities = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)

fun convertInfixIntoPostfix(notation: String): String {

    val operator = Stack<String>()
    val stack = Stack<String>()

    val m = notation.split(" ")

    m.forEach {
        if (it[0] in '0'..'9') {
            stack.push(it)
        } else if (it in operatorPriorities.keys) {
            var flag = false
            while (!operator.isEmpty()) {
                val temp = operator.peek()
                if (operatorPriorities.getOrDefault(it, 0) > operatorPriorities.getOrDefault(temp, 0)) {
                    operator.push(it)
                    flag = true
                    break
                } else
                    stack.push(operator.pop())
            }
            if (!flag)
                operator.push(it)
        }
    }
    while (!operator.isEmpty())
        stack.push(operator.pop())
    val res = MutableList(0) { "" }
    while (!stack.isEmpty())
        res.add(stack.pop())
    val result = StringBuilder("")
    for (i in res.size - 1 downTo 0) {
        if (i != 0)
            result.append("${res[i]} ")
        else
            result.append(res[i])
    }
    return result.toString()
}

fun calculateByPostfix(notation: String): Int {
    val stack = Stack<Long>()

    val m = notation.split(" ")

    for (i in m.indices) {
        if (m[i][0] in '0'..'9')
            stack.push(m[i].toLong())
        else {
            val x = stack.pop()
            val y = stack.pop()
            val cal = when (m[i]) {
                "+" -> ::add
                "-" -> ::subtract
                "*" -> ::multiply
                "/" -> ::divide
                else -> ::add
            }
            stack.push(cal(y, x))
        }
    }
    return stack.pop().toInt()
}

fun add(x: Long, y: Long): Long {
    return x + y
}

fun subtract(x: Long, y: Long): Long {
    return x - y
}

fun multiply(x: Long, y: Long): Long {
    return x * y
}

fun divide(x: Long, y: Long): Long {
    return x / y
}