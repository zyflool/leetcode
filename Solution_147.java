/*
147. 对链表进行插入排序
对链表进行插入排序。
插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

插入排序算法：
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。

示例 1：
输入: 4->2->1->3
输出: 1->2->3->4

示例 2：
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] l = new ListNode[]{new ListNode(4), new ListNode(2), new ListNode(1), new ListNode(3)};
        l[0].next = l[1];
        l[1].next = l[2];
        l[2].next = l[3];
        ListNode t = l[0];
        while ( t != null ) {
            System.out.print(t.val+" ");
            t = t.next;
        }
        System.out.println();
        t = solution.insertionSortList(l[0]);
        while ( t != null ) {
            System.out.print(t.val+" ");
            t = t.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if ( head == null )
            return null;
        if ( head.next == null )
            return head;
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode cur = head.next;
        head.next = null;
        while ( cur != null ) {
            ListNode c = prehead.next;
            ListNode p = prehead;
            ListNode n = cur.next;
            while ( c != null && c.val < cur.val ) {
                c = c.next;
                p = p.next;
            }
            p.next = cur;
            cur.next = c;
            cur = n;
        }
        return prehead.next;
    }

}