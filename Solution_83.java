/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2
输出: 1->2

示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
*/
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1};
        ListNode head = ListNode.produce(nums);
        Solution solution = new Solution();
        System.out.println(head.toString());
        System.out.println(solution.deleteDuplicates(head).toString());
    }

    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null )
            return head;
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        while ( head != null ) {
            if ( head.next != null && head.val == head.next.val ) {
                head.next = head.next.next;
            } else
                head = head.next;
        }
        return dummy.next;
    }
}