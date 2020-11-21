package com.zyflool.kotlin

import java.util.*

/*
224. 基本计算器
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格。

示例 1:
输入: "1 + 1"
输出: 2

示例 2:
输入: " 2-1 + 2 "
输出: 3

示例 3:
输入: "(1+(4+5+2)-3)+(6+8)"
输出: 23

说明：
你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
 */
fun main() {
    println(calculate("0-2147483647"))
}

fun calculate(s: String): Int {
    if (!s.contains("+") && !s.contains("-")) {
        var s1 = s.replace(" ", "")
        s1 = s1.replace(")", "")
        s1 = s1.replace("(", "")
        return s1.toInt()
    }
    val notation = s.replace(" ", "").toMutableList()
    var i = 0

    while (i < notation.size) {
        if (notation[i] == '(' || notation[i] == ')' || notation[i] == '+' || notation[i] == '-') {
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
    //println(notation.joinToString(separator = ""))
    //println(convertInfixIntoPostfix(notation.joinToString(separator = "")))
    return calculateByPostfix(convertInfixIntoPostfix(notation.joinToString(separator = "")))

}

fun convertInfixIntoPostfix(notation: String): String {

    val operator = Stack<String>()
    val stack = Stack<String>()

    val m = notation.split(" ")

    m.forEach {
        if (it[0] in '0'..'9') {
            stack.push(it)
        } else if (it == "+" || it == "-") {
            while (!operator.isEmpty() && operator.peek() != "(") {
                stack.push(operator.pop())
            }
            operator.push(it)
        } else {
            if (it == "(")
                operator.push(it)
            if (it == ")") {
                while (operator.peek() != "(")
                    stack.push(operator.pop())
                operator.pop()
            }
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