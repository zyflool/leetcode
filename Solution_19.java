/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.

说明：
给定的 n 保证是有效的。

进阶：
你能尝试使用一趟扫描实现吗？
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main ( String[] args ) {
        ListNode head = new ListNode(1);
        int n = 2;
        head.next = new ListNode(2);
        ListNode tmp = head.next;
        tmp.next = new ListNode(3);
        ListNode tmp2 = tmp.next;
        tmp2.next = new ListNode(4);
        tmp = tmp2.next;
        tmp.next = new ListNode(5);
        tmp.next.next = null;

        ListNode m = removeNthFromEnd(head, n);
        do {
            System.out.println(m.val);
            m = m.next;
        }while ( m != null );

     }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode latter = head;
        ListNode former = head;
        for (int i = 0 ; i < n ; i++)
            former = former.next;
        if ( former == null ) {
            head = head.next;
            return head;
        } else
            former = former.next;
        while ( former != null ) {
            latter = latter.next;
            former = former.next;
        }
        ListNode tmp = latter.next;
        latter.next = tmp.next;
        return head;
    }
}