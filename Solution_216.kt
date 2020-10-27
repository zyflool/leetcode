package com.zyflool.kotlin

import java.util.*

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：
所有数字都是正整数。
解集不能包含重复的组合。

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]

示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
*/

fun main(args: Array<String>) {
    println(combinationSum3(3, 7))
}

val sumLists = ArrayList<ArrayList<Int>>()
fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    if (k == 0 || n == 0) return sumLists
    val intArray = IntArray(9) { it + 1 }
    dfs(intArray, 0, k, n, ArrayList())
    return sumLists
}

fun dfs(intArray: IntArray, start: Int, k: Int, n: Int, list: ArrayList<Int>) {
    if (start >= intArray.size) return

    for (i in start until intArray.size) {
        if (list.size == k - 1) {
            if (intArray[i] == n) {
                list.add(n)
                sumLists.add(ArrayList(list))
                list.removeAt(list.size - 1)
            }
        } else {
            if (intArray[i] <= n) {
                list.add(intArray[i])
                dfs(intArray, i + 1, k, n - intArray[i], list)
                list.removeAt(list.size - 1)
            }
        }
    }
}