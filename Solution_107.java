/*
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{ new TreeNode(1), new TreeNode(2), new TreeNode(3), new TreeNode(4), new TreeNode(5) };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3]; n[1].right = n[4];
        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(n[0]));

    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if ( root == null ) return res;
        help(root, 0);
        return res;

    }

    public void help(TreeNode root, int level) {
        if ( root == null )
            return;
        if ( res.size() <= level )
            res.add(0, new ArrayList<>());
        List<Integer> list = res.get(res.size() - level - 1);
        list.add(root.val);
        help(root.left, level + 1);
        help(root.right, level + 1);
    }
}
