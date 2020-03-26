/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode[] nodes = new TreeNode[]{
                new TreeNode(1),new TreeNode(2),new TreeNode(3),new TreeNode(4)
        };
        nodes[0].right = nodes[1];
        nodes[1].left = nodes[2];
        nodes[2].left = nodes[3];
        System.out.println(solution.postorderTraversal(nodes[0]));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        if ( root.left == null && root.right == null ) {
            res.add(root.val);
            return res;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while ( !stack.isEmpty() ) {
            TreeNode cur = stack.getLast();
            System.out.println(cur.val+"   "+map.getOrDefault(cur, -1));
            for ( int i = 0 ; i < stack.size() ; i++ )
                System.out.print(stack.get(i).val+" ");
            System.out.println();

            if( !map.containsKey(cur) )
                map.put(cur, 1);
            else
                map.replace(cur, map.get(cur)+1);

            if ( map.get(cur) == 3 ) {
                res.add(cur.val);
                stack.pollLast();
            } else if ( cur.left != null && map.get(cur) == 1 ) {
                stack.add(cur.left);
            } else if ( cur.right != null ) {
                stack.add(cur.right);
                map.replace(cur, 2);
            } else {
                res.add(cur.val);
                stack.pollLast();
            }
        }
        return res;
    }

}
