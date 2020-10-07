package com.zyflool.kotlin

import java.util.*
import kotlin.collections.ArrayList

/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */


fun main(args: Array<String>) {
    val node = Array(5){
        run { TreeNode(it + 1) }}
    node[0].left = node[1]
    node[1].right = node[4]
    node[0].right = node[2]
    node[2].right = node[3]
    println(rightSideView(node[0]).joinToString())
}

/**
 * 深度优先搜索
 */
//var count = -1
//
//fun rightSideView(root: TreeNode?): List<Int> {
//    val list = ArrayList<Int>()
//    if ( root == null )
//        return list
//    dfs(root, 0, list)
//    return list
//}
//
//fun dfs(node: TreeNode, depth: Int, list: ArrayList<Int>): Unit{
//    if ( depth > count ) {
//        count++
//        list.add(node.`val`)
//    }
//    if (node.right != null)
//        dfs(node.right!!, depth+1, list)
//    if (node.left != null)
//        dfs(node.left!!, depth+1, list)
//}

fun rightSideView(root: TreeNode?): List<Int> {
    if ( root == null )
        return ArrayList()
    var count = -1
    val list = ArrayList<Int>()
    val queue = LinkedList<Record>()
    queue.add(Record(root, 0))
    while ( !queue.isEmpty() ) {
        val t = queue.poll()
        if ( t.depth > count ) {
            count++
            list.add(t.node.`val`)
        }
        if ( t.node.right != null )
            queue.add(Record(t.node.right!!, t.depth+1))
        if ( t.node.left != null )
            queue.add(Record(t.node.left!!, t.depth+1))
    }
    return list
}
class Record(node: TreeNode, depth: Int) {
    val node: TreeNode = node
    val depth: Int = depth
}