package com.zyflool.kotlin

/*
203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */

fun main(args: Array<String>) {
    val nodes = Array<ListNode>(6){ ListNode(1) }
    nodes[0].`val` = 1
    nodes[0].next = nodes[1]
    nodes[1].`val` = 2
    nodes[1].next = nodes[2]
    nodes[2].`val` = 3
    nodes[2].next = nodes[3]
    nodes[3].`val` = 4
    nodes[3].next = nodes[4]
    nodes[4].`val` = 5
    nodes[4].next = nodes[5]
    nodes[5].`val` = 6
    var t = removeElements(nodes[0],1)
    while ( t != null ) {
        print("${t.`val`} ")
        t = t.next
    }
    //println(removeElements(nodes[0], 6))
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if ( head == null )
        return null
    else {
        val root = ListNode(0)
        root.next = head
        var pre: ListNode = root
        var cur: ListNode? = head
        while ( cur != null ) {
            if ( cur.`val` == `val` )
                pre.next = cur.next
            else
                pre = cur
            cur = pre.next
        }
        return root.next
    }
}