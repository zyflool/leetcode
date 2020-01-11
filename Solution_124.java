/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:
输入: [1,2,3]

       1
      / \
     2   3
输出: 6

示例 2:
输入: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
输出: 42
 */

import static java.lang.Math.max;

public class Solution {
    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[]{
                new TreeNode(-10),  new TreeNode(9),
                new TreeNode(20),  new TreeNode(15),
                new TreeNode(7),
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[2].left = nodes[3];
        nodes[2].right = nodes[4];
        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(nodes[0]));
    }

    private int res = Integer.MIN_VALUE;

    private int max_gain(TreeNode root) { //求从当前节点开始向下的路径最大值

        if ( root == null )
            return 0;

        int left_gain = max(max_gain(root.left), 0); //当前节点的左侧分枝的最大路径
        int right_gain = max(max_gain(root.right), 0); //当前节点的右侧分枝的最大路径

        int new_path = root.val + left_gain + right_gain;

        res = Math.max(new_path, res); //如果当前节点左右两侧之和较大，更新答案

        return root.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root); //遍历树
        return res;
    }
}
