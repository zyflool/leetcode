/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(root));
    }

    private  List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }

    private void solve ( TreeNode root ) {
        if ( root == null )
            return ;
        if ( root.left == null ) {
            ans.add(root.val);
            inorderTraversal(root.right);
        } else {
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
        }
    }
}