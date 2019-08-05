/*
2. 两数相加
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l;
        int addition;
        boolean flag;
        addition = l1.val + l2.val;
        if (addition >= 10) {
            addition -= 10;
            flag = true;
        } else flag = false;
        l = new ListNode(addition);
        l1 = l1.next;
        l2 = l2.next;
        ListNode result = l;
        while ( l1 != null && l2 != null) {
            if (flag) l.next = new ListNode(1);
            else l.next = new ListNode(0);
            addition = l1.val + l2.val;
            if (addition >= 10) {
                addition -= 10;
                flag = true;
            } else flag = false;
            l.next.val += addition;
            if ( l.next.val >= 10 ) {
                flag = true;
                l.next.val -= 10;
            }
            l1 = l1.next;
            l2 = l2.next;
            l = l.next;
        }
        if (l1 == null && l2 != null) {
            while (l2!=null) {
                if (flag == true) {
                    l.next = new ListNode(1);
                    l.next.val += l2.val;
                    if ( l.next.val >= 10 ) {
                        l.next.val -= 10;
                        flag =true;
                    } else flag = false;
                } else l.next = new ListNode(l2.val);
                l = l.next;
                l2 = l2.next;
            }
        }
        if (l1 != null && l2 == null) {
            while (l1 != null) {
                if (flag == true) {
                    l.next = new ListNode(1);
                    l.next.val += l1.val;
                    if ( l.next.val >= 10 ) {
                        l.next.val -= 10;
                        flag =true;
                    } else flag = false;
                } else l.next = new ListNode(l1.val);
                l = l.next;
                l1 = l1.next;
            }
        }
        if (l1 == null && l2 == null) {
            if (flag == true)
                l.next = new ListNode(1);
        }
        if ( l.val >= 10 ) {
            l.next = new ListNode(1);
            l.val -= 10;
        }
        return result;
    }
}
