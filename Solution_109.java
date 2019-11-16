/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        ListNode head = ListNode.produce(nums);
        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root.val);
        System.out.println(root.left.val+"  "+root.right.val);
        System.out.println(root.left.left.val+"  "+root.right.left.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null ) return new TreeNode(head.val);
        else {
            ListNode end = head;
            while ( end != null )
                end = end.next;
            return solve(head, null);
        }
    }

    private TreeNode solve(ListNode start, ListNode end) {
        if ( start.next == end )
            return new TreeNode(start.val);
        ListNode mid = start;
        ListNode stop = start;
        ListNode pre;
        while ( stop != end ) {
            pre = mid;
            mid = mid.next;
            stop = stop.next;
            if ( stop == end ) {
                mid = pre;
                break;
            }
            else stop = stop.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = solve(start, mid);
        if ( mid.next == end ) {
            root.right = null;
            return root;
        }
        root.right = solve(mid.next, end);
        return root;
    }
}
