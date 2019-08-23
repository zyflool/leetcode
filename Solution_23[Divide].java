/*
23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/
/**
 * 分治
 */
class Solution {

    public static void main ( String[] args ) {
        int[] num1 = new int[]{1,4,5};
        int[] num2 = new int[]{1,3,4};
        int[] num3 = new int[]{2,6};
        ListNode head1 = ListNode.produce(num1);
        ListNode head2 = ListNode.produce(num2);
        ListNode head3 = ListNode.produce(num3);
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        ListNode head = mergeKLists(lists);
        System.out.println(head.toString());
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}