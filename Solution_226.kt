package com.zyflool.kotlin

/*
226. 翻转二叉树
翻转一棵二叉树。

示例：
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

fun main() {
    val tree = List<TreeNode>(7){ TreeNode(0) }
    tree[0].`val` = 4
    tree[1].`val` = 2
    tree[2].`val` = 7
    tree[3].`val` = 1
    tree[4].`val` = 3
    tree[5].`val` = 6
    tree[6].`val` = 9
    tree[0].left = tree[1]
    tree[0].right = tree[2]
    tree[1].left = tree[3]
    tree[1].right = tree[4]
    tree[2].left = tree[5]
    tree[2].right = tree[6]
    val root = invertTree(tree[0])

}

fun invertTree(root: TreeNode?): TreeNode? {
    root?.let{
        val t = it.left
        it.left = it.right
        it.right = t
        invertTree(it.left)
        invertTree(it.right)
    }
    return root
}