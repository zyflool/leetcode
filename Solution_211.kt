package com.zyflool.kotlin

/*
211. 添加与搜索单词 - 数据结构设计
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。

示例：
输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

提示：
1 <= word.length <= 500
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最调用多 50000 次 addWord 和 search
*/

fun main(args: Array<String>) {
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    println(wordDictionary.search("pad")) // return False
    println(wordDictionary.search("bad")) // return True
    println(wordDictionary.search(".ad")) // return True
    println(wordDictionary.search("b..")) // return True
}

class WordDictionary() {

    var is_string = false
    val next = arrayOfNulls<WordDictionary>(26)

    fun addWord(word: String) {
        var root = this
        val w = word.toCharArray()
        for (i in w.indices) {
            if (root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = WordDictionary()
            root = root.next[w[i] - 'a']!!
        }
        root.is_string = true
    }

    var searchRes = false
    fun search(word: String): Boolean {
        searchRes = false
        searchHelper(this, word)
        return searchRes
    }

    fun searchHelper(node: WordDictionary, word: String) {
        if (word.isEmpty()) {
            if (node.is_string)
                searchRes = true
            return
        }
        val w = word.toCharArray()
        if (w[0] == '.') {
            for (j in 0..25)
                if (node.next[j] != null)
                    searchHelper(node.next[j]!!, word.substring(1))
        } else if (node.next[w[0] - 'a'] != null)
            searchHelper(node.next[w[0] - 'a']!!, word.substring(1))
    }
}