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
 * 优先队列
 */

import java.util.Comparator;
import java.util.PriorityQueue;

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
        int k = lists.length;
        if (k == 0)
            return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a.val));
        ListNode prehead = new ListNode(-1);
        ListNode head = prehead;
        for (ListNode list : lists) {
            if (list != null)
                priorityQueue.add(list);
        }
        while ( !priorityQueue.isEmpty() ) {
            head.next = priorityQueue.poll();
            head = head.next;
            if(head.next!=null)
                priorityQueue.add(head.next);
        }
        return prehead.next;
    }
}