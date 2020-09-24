package com.zyflool.kotlin

import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/*
173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。

示例：
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false

提示：
next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */

fun main(args: Array<String>) {
    var n:Array<TreeNode> = Array(5) {TreeNode(0)}
    n[0].`val` = 7
    n[1].`val` = 3
    n[2].`val` = 15
    n[3].`val` = 9
    n[4].`val` = 20
    n[0].left = n[1]
    n[0].right = n[2]
    n[2].left = n[3]
    n[2].right = n[4]
    var iterator = BSTIterator(n[0])
    println(iterator.next())    // 返回 3
    println(iterator.next())    // 返回 7
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())    // 返回 9
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())    // 返回 15
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())    // 返回 20
    println(iterator.hasNext()) // 返回 false
}

class BSTIterator(root: TreeNode?) {
    var list: ArrayList<Int> = ArrayList()
    var it: Int = 0
    init {
        LDR(root)
    }

    fun LDR(root: TreeNode?) {
        if(root ==null){
            return
        }
        LDR(root.left)
        list.add(root.`val`)
        LDR(root.right)
    }

    fun next(): Int {
        return list[it++]
    }

    fun hasNext(): Boolean {
        return it < list.size
    }
}