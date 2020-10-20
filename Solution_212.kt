package com.zyflool.kotlin

/*
212. 单词搜索 II
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母在一个单词中不允许被重复使用。

示例:
输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:
你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
*/
/**
 * 字典树 + 深度优先遍历 + 回溯 + 剪枝
 */

fun main(args: Array<String>) {
    val board = Array(3) { charArrayOf() }
    board[0] = charArrayOf('a', 'b', 'c')
    board[1] = charArrayOf('a', 'e', 'd')
    board[2] = charArrayOf('a', 'f', 'g')
    val words = Array(6) { "a" }
    words[0] = "abcdefg"
    words[1] = "gfedcbaaa"
    words[2] = "eaabcdgfa"
    words[3] = "befa"
    words[4] = "dgc"
    words[5] = "ade"
    println(findWords(board, words))
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    if (board.isEmpty() || board[0].isEmpty())
        return ArrayList()

    val trie = Trie()
    words.forEach { trie.insert(it) }

    val ans = HashSet<String>()

    for (i in board.indices) {
        for (j in board[0].indices) {
            val visited = Array(board.size) { BooleanArray(board[0].size) { false } }
            visited[i][j] = true
            findHelper(i, j, board[i][j].toString(), visited, board, trie, ans)
        }
    }
    return ans.toList()
}

fun findHelper(
    x: Int,
    y: Int,
    word: String,
    visited: Array<BooleanArray>,
    board: Array<CharArray>,
    trie: Trie,
    ans: HashSet<String>
) {
    if (trie.search(word)) {
        ans.add(word)
    }
    if (trie.startsWith(word)) {
        val move = Array(4) { IntArray(2) }
        move[0] = intArrayOf(1, 0)
        move[1] = intArrayOf(-1, 0)
        move[2] = intArrayOf(0, 1)
        move[3] = intArrayOf(0, -1)

        for (i in 0..3) {
            val x1 = x + move[i][0]
            val y1 = y + move[i][1]
            if (x1 != -1 && x1 != board.size && y1 != -1 && y1 != board[0].size) {
                if (!visited[x1][y1]) {
                    val Nword = word + board[x1][y1]
                    visited[x1][y1] = true
                    findHelper(x1, y1, Nword, visited, board, trie, ans)
                    visited[x1][y1] = false
                }
            }
        }
    } else {
        visited[x][y] = false
        return
    }
}

class Trie() {
    class Node(val chr: Char) {
        var isEnd: Boolean = false;
        private val next: Array<Node?> = arrayOfNulls(26)
        fun insert(char: Char): Node {
            var index = char - 'a';
            var node = next[index]
            if (node == null) {
                node = Node(char)
                next[index] = node
            }
            return node
        }

        fun search(char: Char): Node? = next[char - 'a']
    }

    val root: Node = Node('\u0000')

    fun insert(word: String) {
        val eow = word.fold(root) { node, c ->
            node.insert(c)
        }
        eow.isEnd = true
    }

    fun search(word: String): Boolean {
        var node: Node? = root
        for (chr in word) {
            node = node?.search(chr)
            node ?: return false
        }
        return node?.isEnd ?: false
    }

    fun startsWith(prefix: String): Boolean {
        var node: Node? = root
        for (chr in prefix) {
            node = node?.search(chr)
            node ?: return false
        }
        return node != null
    }
}
