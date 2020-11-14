package com.zyflool.kotlin

/*
222. 完全二叉树的节点个数
给出一个完全二叉树，求出该树的节点个数。

说明：
完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:
输入:
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6
*/

fun main(args: Array<String>) {
    var nodes = Array(6){ TreeNode(0) }
    nodes[0].`val` = 1
    nodes[1].`val` = 2
    nodes[2].`val` = 3
    computeDepth(nodes[0])
}

fun computeDepth(node: TreeNode): Int {
    var d = 0
    var n = node
    while (n.left != null) {
        n = n.left!!
        ++d
    }
    return d
}

fun exists(idx: Int, d: Int, n: TreeNode): Boolean {
    var left = 0
    var right = 2.shl(d) - 1
    var pivot = 0
    var node = n
    for (i in 0 until d) {
        pivot = left + (right - left) / 2;
        if (idx <= pivot) {
            node = node.left!!
            right = pivot;
        } else {
            node = node.right!!
            left = pivot + 1
        }
    }
    return node != null
}

fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0

    val d = computeDepth(root)
    if (d == 0) return 1

    var left = 1
    var right = 2.shl(d) - 1
    var pivot: Int
    while (left <= right) {
        pivot = left + (right - left) / 2
        if (exists(pivot, d, root)) left = pivot + 1
        else right = pivot - 1;
    }
    return 2.shl(d) - 1 + left
}