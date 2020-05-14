/*
148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:
输入: 4->2->1->3
输出: 1->2->3->4

示例 2:
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
        t = solution.sortList(l[0]);
        while ( t != null ) {
            System.out.print(t.val+" ");
            t = t.next;
        }
    }

    public ListNode sortList(ListNode head) {
        //递归终止条件
        if ( head == null || head.next == null )
            return head;
        //快慢指针找到中点
        ListNode fast = head.next;
        ListNode low = head;
        while ( fast != null && fast.next != null ) {
            fast = fast.next.next;
            low = low.next;
        }
        //找到中点,截断链表
        ListNode temp = low.next;
        low.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode cur = new ListNode(0);
        h.next = cur;
        //合并链表
        while ( left != null && right != null ) {
            if ( left.val <= right.val ) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        if ( left != null )
            cur.next = left;
        if ( right != null )
            cur.next = right;
        return h.next.next;
    }

}