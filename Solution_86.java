/*
86. 分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例:
输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
*/
/*
双指针
遍历链表将节点分开成两个新链表
遍历后再将两个链表连接成一个链表
 */
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,5,2};
        int x = 3;
        ListNode head = ListNode.produce(nums);
        Solution solution = new Solution();
        System.out.println(solution.partition(head,x).toString());
    }

    public ListNode partition(ListNode head, int x) {
        ListNode prehead1 = new ListNode(-1);
        ListNode prehead2 = new ListNode(-1);
        ListNode cur1 = prehead1;
        ListNode cur2 = prehead2;
        while ( head != null ) {
            if ( head.val < x ) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = prehead2.next;
        return prehead1.next;
    }
}