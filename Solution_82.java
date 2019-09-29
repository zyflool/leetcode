/*
82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3
*/

/*
快慢指针
 */

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,4,5};
        ListNode head = ListNode.produce(nums);
        Solution solution = new Solution();
        System.out.println(solution.deleteDuplicates(head).toString());
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode prehead = new ListNode(-1000);
        prehead.next = head;
        ListNode slow = prehead;
        ListNode fast = prehead.next;
        while (fast != null) {
            while ( fast.next != null && fast.val == fast.next.val )
                fast = fast.next;
            if ( slow.next == fast )
                slow = slow.next;
            else
                slow.next = fast.next;
            fast = fast.next;
        }
        return prehead.next;
    }
}