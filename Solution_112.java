/*
112. 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{
                new TreeNode(5),
                new TreeNode(4),
                new TreeNode(8),
                new TreeNode(11),
                new TreeNode(13),
                new TreeNode(4),
                new TreeNode(7),
                new TreeNode(2),
                new TreeNode(1)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3];
        n[2].left = n[4]; n[2].right = n[5];
        n[3].left = n[6]; n[3].right = n[7];
        n[5].right = n[8];
        int sum = 22;
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(n[0],sum));

    }

    private boolean answer = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        solve(root, sum - root.val);
        return answer;
    }

    private void solve (TreeNode root, int sum) {
        if ( sum == 0 && root.right == null && root.left == null) {
            answer = true;
            return;
        }
        if (root.left != null) solve(root.left, sum - root.left.val);
        if (root.right != null) solve(root.right, sum - root.right.val);
    }
}
