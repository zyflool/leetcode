/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode[] nodes = new TreeNode[]{
                new TreeNode(1),new TreeNode(2),new TreeNode(3),new TreeNode(4)
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[2].left = nodes[3];
        System.out.println(solution.preorderTraversal(nodes[0]));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        if ( root.left == null && root.right == null ) {
            res.add(root.val);
            return res;
        }
        Map<TreeNode, Integer> nodeList = new HashMap<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while ( !stack.isEmpty() ) {
            TreeNode cur = stack.getLast();
            if ( nodeList.getOrDefault(cur, 0) == 0 ) {
                res.add(cur.val);
                nodeList.put(cur,1);
                if ( cur.left != null ) {
                    stack.add(cur.left);
                } else if ( cur.right != null ) {
                    stack.add(cur.right);
                } else
                    stack.pollLast();
            } else if ( cur.right != null && nodeList.getOrDefault(cur.right, 0) == 0 ) {
                stack.add(cur.right);
            } else {
                stack.pollLast();
            }
        }
        return res;
    }

}
