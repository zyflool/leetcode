/*
138. 复制带随机指针的链表
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。


示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]

示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]

示例 4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

提示：
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        /*
        输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
         */

        Node[] nodes = new Node[]{
                new Node(7), new Node(13), new Node(11), new Node(10), new Node(1)
        };
        nodes[0].next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        nodes[1].random = nodes[0];
        nodes[2].random = nodes[4];
        nodes[3].random = nodes[2];
        nodes[4].random = nodes[0];
        Solution solution = new Solution();
        Node t = nodes[0];
        while ( t != null ) {
            System.out.print(t+"["+t.val+",");
            if ( t.random == null )
                System.out.print("null], ");
            else
                System.out.print(t.random+"], ");
            t = t.next;
        }
        System.out.println();

        Node res = solution.copyRandomList(nodes[0]);
        t = nodes[0];
        while ( t != null ) {
            System.out.print(t+"["+t.val+",");
            if ( t.random == null )
                System.out.print("null], ");
            else
                System.out.print(t.random+"], ");
            t = t.next;
        }
        System.out.println();
        while ( res != null ) {
            System.out.print(res+"["+res.val+",");
            if ( res.random == null )
                System.out.print("null], ");
            else
                System.out.print(res.random+"], ");
            res = res.next;
        }
    }


    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node cur = head;

        while ( cur != null ) {
            Node n = new Node(cur.val);
            n.next = cur.next;
            cur.next = n;
            cur  = n.next;
        }

        cur = head;

        while ( cur != null ) {
            if ( cur.random != null ) {
                cur.next.random = cur.random.next;
            } else cur.next.random = null;
            cur = cur.next.next;
        }


        Node ans = head.next;
        cur = head;
        Node ncur = ans;
        while ( ncur.next != null ) {
            cur.next = cur.next.next;
            cur = cur.next;
            ncur.next = cur.next;
            ncur = ncur.next;
        }
        cur.next = null;

        return ans;
    }
}