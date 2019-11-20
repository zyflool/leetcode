/*
117. 填充每个节点的下一个右侧节点指针 II
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。

示例：
输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。

提示：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
class Solution {

    public static void main(String[] args) {
        Node[] n = new Node[]{
                new Node(1), new Node(2),
                new Node(3), new Node(4),
                new Node(5), new Node(6),
                new Node(7) };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3]; n[1].right = n[4];
        n[2].left = n[5]; n[2].right = n[6];
        Solution solution = new Solution();
        System.out.println(solution.connect(n[0]));
    }

    public Node connect(Node root) {
        Node cur = root;
        Node head = null;
        Node tail = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                        tail = head;
                    } else {
                        tail.next = cur.left;
                        tail = tail.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                        tail = head;
                    } else {
                        tail.next = cur.right;
                        tail = tail.next;
                    }
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            tail = null;
        }
        return root;
    }
}
