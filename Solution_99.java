/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。

示例 1:
输入: [1,3,null,null,2]
   1
  /
 3
  \
   2
输出: [3,1,null,null,2]
   3
  /
 1
  \
   2

示例 2:
输入: [3,1,4,null,null,2]
  3
 / \
1   4
   /
  2
输出: [2,1,4,null,null,3]
  2
 / \
1   4
   /
  3

进阶:
使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
*/
/*
二叉搜索树的中序遍历是顺序的
中序遍历，找到两个不正常的点交换值
 */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[] {
                new TreeNode(1), new TreeNode(3), new TreeNode(2)
        };
        n[0].left = n[1];
        n[1].right = n[2];
        Solution solution = new Solution();
        solution.recoverTree(n[0]);
        System.out.println(n[0].val);
        System.out.println(n[0].left.val);
        System.out.println(n[1].right.val);
    }

    private List<TreeNode> l = new ArrayList<>();
    TreeNode n1 = null, n2 = null;

    public void recoverTree (TreeNode root) {
        solve(root);
        int t;
        t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }

    private void solve (TreeNode root) {
        if ( root == null )
            return;
        solve(root.left);
        l.add(root);
        if ( l.size() != 1 ) {
            if ( l.get(l.size() -1 ).val < l.get(l.size()-2).val ) {
                if ( n1 == null )
                    n1 = l.get(l.size() - 2);
                if (n1 != null )
                    n2 = l.get(l.size() - 1);
            }
        }
        solve(root.right);
    }

}
