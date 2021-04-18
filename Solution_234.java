import java.util.List;

/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
/*
找中点 + 反转链表 + 比较
递归
 */
public class Solution_234 {
    public static void main(String[] args) {
        Solution_234 solution = new Solution_234();
        ListNode[] nodes = new ListNode[4];
        nodes[0] = new ListNode(1);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(2);
        nodes[3] = new ListNode(1);
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        System.out.println(solution.isPalindrome(nodes[0]));
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
