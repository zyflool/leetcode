package com.zyflool.kotlin

/*
187. 重复的DNA序列
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

示例：
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */

fun main(args: Array<String>) {
    println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").joinToString())
}

/**
 * 把每个子串按四进制转换成十进制的数字，利用集合元素的唯一性进行判重
 */
fun findRepeatedDnaSequences(s: String): List<String> {
    val shownSet = HashSet<Int>()
    val resSet = HashSet<String>()
    val addedSet = HashSet<Int>()
    for ( i in 0..s.length-10) {
        val str = s.substring(i, i+10)
        val t = convertToNum(str)
        if ( !shownSet.contains(t))
            shownSet.add(t)
         else if ( !addedSet.contains(t) ) {
            addedSet.add(t)
            resSet.add(str)
        }
    }
    return resSet.toList()
}

private fun convertToNum(s: String): Int {
    /**
     * A-0
     * C-1
     * G-2
     * T-3
     */
    var num = 0
    var times = 1
    s.forEach {
        when (it) {
            'A' -> num += times*0
            'C' -> num += times*1
            'G' -> num += times*2
            'T' -> num += times*3
        }
        times *= 4
    }
    return num
}