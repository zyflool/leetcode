package com.zyflool.kotlin
/*
160. 相交链表
编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：
在节点 c1 开始相交。

示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

示例 2：
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

示例 3：
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。

注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

/**
 * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。为此，我们必须消除两个链表的长度差
 * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 * 如果 pA 到了末尾，则 pA = headB 继续遍历
 * 如果 pB 到了末尾，则 pB = headA 继续遍历
 * 比较长的链表指针指向较短链表head时，长度差就消除了
 * 如此，只需要将最短链表遍历两次即可找到位置
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 */
fun main(args: Array<String>) {
    var nodes: Array<ListNode> = Array(8){ListNode(0)}
    nodes[0].x = 4
    nodes[1].x = 1

    nodes[2].x = 8
    nodes[3].x = 4
    nodes[4].x = 5

    nodes[5].x = 5
    nodes[6].x = 0
    nodes[7].x = 1

    nodes[0].next = nodes[1]
    nodes[1].next = nodes[2]

    nodes[5].next = nodes[6]
    nodes[6].next = nodes[7]
    nodes[7].next = nodes[2]

    nodes[2].next = nodes[3]
    nodes[3].next = nodes[4]

    val res = getIntersectionNode(nodes[0], nodes[5])

    if ( res == null )
        println("null")
    else println(res.x)
}

fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
    if ( headA == null || headB == null )
        return null

    var pA = headA
    var pB = headB
    while ( pA != pB ) {
        pA = if ( pA == null )
            headB
        else
            pA.next
        pB = if ( pB == null )
            headA
        else
            pB.next
    }

    return pA
}