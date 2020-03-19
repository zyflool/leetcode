/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

/*
1、快慢指针找中点
2、翻转后半段链表
3、插入
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] nodes = new ListNode[]{
                new ListNode(1),new ListNode(2),new ListNode(3),new ListNode(4),new ListNode(5) };
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        ListNode t = nodes[0];
        while ( t != null ) {
            System.out.print(t+"+"+t.val+", ");
            t = t.next;
        }
        System.out.println();
        solution.reorderList(nodes[0]);
        t = nodes[0];
        while ( t != null ) {
            System.out.print(t+"+"+t.val+", ");
            t = t.next;
        }
    }

    public void reorderList(ListNode head) {
        if ( head == null || head.next == null || head.next.next == null)
            return;
        ListNode mid = getMiddle(head);
        mid = reverseList(mid);
        System.out.print("翻转后：");
        ListNode t = mid;
        while ( t != null ) {
            System.out.print(t+"+"+t.val+", ");
            t = t.next;
        }
        System.out.println();
        intersectList(head, mid);
    }

    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        ListNode pre = new ListNode(0);
        while ( fast != null && fast.next != null ) {
            fast = fast.next.next;
            pre = low;
            low = low.next;
        }
        if ( fast != null ) {
            ListNode t = low.next;
            low.next = null;
            return t;
        } else {
            pre.next = null;
            return low;
        }
    }

    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null )
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head.next;
        head.next = null;
        while ( cur != null ) {
            ListNode t = cur.next;
            cur.next = h.next;
            h.next = cur;
            cur = t;
        }
        return h.next;
    }

    public void intersectList(ListNode head, ListNode mid) {
        ListNode f = head, s = mid;
        while ( f != null && s != null ) {
            ListNode m = head;
            while ( m != null ) {
                System.out.print(m+"+"+m.val+", ");
                m = m.next;
            }
            System.out.println();
            System.out.println(f.val+"  "+s.val);
            ListNode t = s.next;
            s.next = f.next;
            f.next = s;
            f = f.next.next;
            s = t;
        }
    }

}