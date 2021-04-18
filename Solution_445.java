/*
445. 两数相加 II
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
/*
最快的方法是反转链表然后相加
题目进阶是使用两个栈完成逆序操作
 */
import java.util.*;

public class Solution_445 {
    public static void main(String[] args) {
        Solution_445 solution = new Solution_445();
        ListNode[] nodes1 = new ListNode[4];
        ListNode[] nodes2 = new ListNode[3];
        nodes1[0] = new ListNode(7);
        nodes1[1] = new ListNode(2);
        nodes1[2] = new ListNode(4);
        nodes1[3] = new ListNode(3);
        nodes2[0] = new ListNode(5);
        nodes2[1] = new ListNode(6);
        nodes2[2] = new ListNode(4);
        nodes1[0].next = nodes1[1];
        nodes1[1].next = nodes1[2];
        nodes1[2].next = nodes1[3];
        nodes2[0].next = nodes2[1];
        nodes2[1].next = nodes2[2];
        solution.addTwoNumbers(nodes1[0],nodes2[0]);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        while (l1 != null) {
            num1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.push(l2.val);
            l2 = l2.next;
        }
        ListNode Head = new ListNode(-1);
        int last = 0;
        while (!num1.isEmpty() && !num2.isEmpty()) {
            int a = num1.pop();
            int b = num2.pop();
            ListNode p = new ListNode((a + b + last) % 10);
            p.next = Head.next;
            Head.next = p;
            last = (a + b + last) / 10;
        }
        while (!num1.isEmpty()) {
            int a = num1.pop();
            ListNode p = new ListNode((a + last) % 10);
            p.next = Head.next;
            Head.next = p;
            last = (a + last) / 10;
        }
        while (!num2.isEmpty()) {
            int a = num2.pop();
            ListNode p = new ListNode((a + last) % 10);
            p.next = Head.next;
            Head.next = p;
            last = (a + last) / 10;
        }
        if (last != 0) {
            ListNode p = new ListNode(last);
            p.next = Head.next;
            Head.next = p;
        }
        return Head.next;
    }

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int value) {
            this.val = value;
        }
    }
}
