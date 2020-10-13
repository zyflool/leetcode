package com.zyflool.kotlin

/*
206. 反转链表
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
*/

fun main(args: Array<String>) {
    var nodes = Array(5){ListNode(it)}
    nodes[0].`val` = 1
    nodes[1].`val` = 2
    nodes[2].`val` = 3
    nodes[3].`val` = 4
    nodes[4].`val` = 5
    nodes[0].next = nodes[1]
    nodes[1].next = nodes[2]
    nodes[2].next = nodes[3]
    nodes[3].next = nodes[4]
    var t = reverseList(nodes[0])
    while ( t != null ) {
        print("${t.`val`} ")
        t = t.next
    }
}

/**
 * 迭代
 */
//fun reverseList(head: ListNode?): ListNode? {
//    if ( head == null ||head.next == null)
//        return head
//
//    val root = ListNode(0)
//    var p = head
//    var next: ListNode?
//    while ( p != null ) {
//        var t = root.next
//        next = p.next
//        root.next = p
//        p.next = t
//        p = next
//    }
//    return root.next
//}

/**
 * 递归
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head == null || head.next == null)
        return head
    val p = reverseList(head.next)
    head!!.next!!.next = head
    head.next = null
    return p
}