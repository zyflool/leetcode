/*
129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。

示例 1:
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.

示例 2:
输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
 */

public class Solution {

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[] {
                new TreeNode(4), new TreeNode(9), new TreeNode(0), new TreeNode(5), new TreeNode(1)
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(nodes[0]));
    }

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return ans;
    }

    private void solve(TreeNode root, int sum) {
        if ( root == null )
            return ;
        if ( root.left != null)
            solve(root.left,  sum*10+root.val);
        if ( root.right != null )
            solve(root.right, sum*10+root.val);
        if ( root.right == null && root.left == null )
            ans += sum*10+root.val;
    }

}