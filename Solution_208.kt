package com.zyflool.kotlin

/*
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
*/

fun main(args: Array<String>) {
    val trie = Trie()
    trie.insert("apple")
    trie.search("apple")   // 返回 true
    trie.search("app")     // 返回 false
    trie.startsWith("app") // 返回 true
    trie.insert("app")
    trie.search("app")     // 返回 true
}

class Trie() {

    /** Initialize your data structure here. */
    class Node(val chr: Char) {
        var isEnd:Boolean = false;
        private val next: Array<Node?> = arrayOfNulls(26)
        fun insert(char: Char): Node {
            var index = char - 'a';
            var node = next[index]
            if(node == null) {
                node = Node(char)
                next[index] = node
            }
            return node
        }
        fun search(char: Char): Node? = next[char - 'a']
    }
    val root: Node = Node('\u0000')

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        val eow = word.fold(root) {
                node, c ->
            node.insert(c)
        }
        eow.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node: Node? = root
        for(chr in word) {
            node = node?.search(chr)
            node ?: return false
        }
        return node?.isEnd ?: false
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node: Node? = root
        for(chr in prefix) {
            node = node?.search(chr)
            node ?: return false
        }
        return node != null
    }

}

