/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
 */
/*
深度优先搜索，从叶子节点开始判断，通过递归保留算过的层数
 */
class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{
                new TreeNode(1),
                new TreeNode(2),
                new TreeNode(2),
                new TreeNode(3),
                new TreeNode(3),
                new TreeNode(4),
                new TreeNode(4)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3]; n[1].right = n[4];
        n[3].left = n[5]; n[3].right = n[6];
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(n[0]));

    }

    private boolean answer = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        solve (root, 0); return answer;
    }

    private int solve(TreeNode root, int floor) {
        if ( root == null ) return floor;
        int left = solve(root.left, floor + 1);
        int right = solve(root.right, floor+1);
        if ( Math.abs(right - left) > 1 ) answer = false;
        return Math.max(left, right);
    }
}
