/*
230. 二叉搜索树中第K小的元素
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

示例 1：
输入：root = [3,1,4,null,2], k = 1
输出：1

示例 2：
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3

提示：
树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104

进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */

/*中序遍历*/

import java.util.*;

public class Solution_230 {
    public static void main(String[] args) {
        Solution_230 solution = new Solution_230();
        TreeNode[] nodes = new TreeNode[4];
        nodes[0] = new TreeNode(1);
        nodes[1] = new TreeNode(2);
        nodes[2] = new TreeNode(3);
        nodes[3] = new TreeNode(4);
        nodes[0].right = nodes[1];
        nodes[2].left = nodes[0];
        nodes[2].right = nodes[3];
        System.out.println(solution.kthSmallest(nodes[2], 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        mid(root);
        return list.get(k-1);
    }

    List<Integer> list = new ArrayList<>();
    int K;

    public void mid(TreeNode root) {
        if (list.size() > K) {
            return;
        }
        if ( root == null)
            return;
        if ( root.left != null )
            mid(root.left);
        list.add(root.val);
        if ( root.right != null )
            mid(root.right);
    }
}
