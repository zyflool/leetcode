package com.zyflool.kotlin

/*
214. 最短回文串
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

示例 1：
输入：s = "aacecaaa"
输出："aaacecaaa"

示例 2：
输入：s = "abcd"
输出："dcbabcd"

提示：
0 <= s.length <= 5 * 10^4
s 仅由小写英文字母组成
*/

fun main(args: Array<String>) {
    println(shortestPalindrome("abbacd"))
}

//fun shortestPalindrome(s: String): String {
//    if (s.isEmpty() || s.length == 1) return s
//    if (s.length == 2) {
//        when {
//            s[0] == s[1] -> return s
//            s[0] != s[1] -> return s[1] + s
//        }
//
//    }
//    val n = s.length
//    var palindrome = s
//    for (i in 1 until s.length)
//        palindrome = s[i] + palindrome
//
//    //双中心
//    for (i in n / 2 downTo 1) {
//        var flag = true
//        println("i = $i")
//        for (j in i - 1 downTo 0) {
//            println("s[j] = '${s[j]}', s[2i-j-1] = '${s[2*i-j-1]}'")
//            if (s[j] != s[2*i - j-1]) {
//                flag = false
//                break
//            }
//        }
//        if (flag) {
//            if ((n - i) * 2 < palindrome.length) {
//                palindrome = s
//                var k = 0
//                while (2 * i + k < n) {
//                    palindrome = s[2 * i + k] + palindrome
//                    k++
//                }
//            }
//            break
//        }
//    }
//
//    //单中心
//    if (s.length % 2 == 1) {
//        for (i in n / 2 downTo 1) {
//            var flag = true
//            for (j in i - 1 downTo 0) {
//                if (s[j] != s[2 * i - j]) {
//                    flag = false
//                    break
//                }
//            }
//            if (flag) {
//                if ((n - i) * 2 - 1 < palindrome.length) {
//                    palindrome = s
//                    var k = 1
//                    while (2 * i + k < n) {
//                        palindrome = s[2 * i + k] + palindrome
//                        k++
//                    }
//                }
//                break
//            }
//        }
//    } else {
//        for (i in (n / 2) - 1 downTo 1) {
//            var flag = true
//            for (j in i - 1 downTo 0) {
//                if (s[j] != s[2 * i - j]) {
//                    flag = false
//                    break
//                }
//            }
//            if (flag) {
//                if ((n - i) * 2 - 1 < palindrome.length) {
//                    palindrome = s
//                    var k = 1
//                    while (2 * i + k < n) {
//                        palindrome = s[2 * i + k] + palindrome
//                        k++
//                    }
//                }
//                break
//            }
//        }
//    }
//
//    return palindrome
//}
fun shortestPalindrome(s: String): String {
    val n: Int = s.length
    val base = 131
    val mod = 1000000007
    var left = 0L
    var right = 0L
    var mul = 1
    var best = -1
    for (i in 0 until n) {
        left = ((left * base + s[i].toLong()) % mod)
        right = ((right + mul.toLong() * s[i].toLong()) % mod)
        if (left == right) {
            best = i
        }
        mul = (mul.toLong() * base % mod).toInt()
    }
    val add = if (best == n - 1) "" else s.substring(best + 1)
    val ans = StringBuffer(add).reverse()
    ans.append(s)
    return ans.toString()
}