/*
100. 相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
输出: true

示例 2:
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]
输出: false

示例 3:
输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
输出: false
 */

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[] {
                new TreeNode(1), new TreeNode(2), new TreeNode(1),
                new TreeNode(1), new TreeNode(1), new TreeNode(2)
        };
        n[0].left = n[1];
        n[0].right = n[2];
        n[3].left = n[4];
        n[3].right = n[5];
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(n[0],n[3]));
    }

    private boolean answer = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        solve(p,q);
        return answer;
    }

    private void solve ( TreeNode p, TreeNode q ) {
        if (p == null && q == null) {
            return ;
        } else if (p != null && q == null) {
            answer = false;
            return;
        } else if (q != null && p == null)  {
            answer = false;
            return ;
        }
        if ( !answer )
            return ;
        if (p.val != q.val) {
            answer = false;
            return ;
        }

        if (p.left != null && q.left != null)
            isSameTree(p.left, q.left);

        if (p.right != null && q.right != null)
            isSameTree(p.right, q.right);

        if ((p.right == null && q.right != null) ||
                (p.right != null && q.right == null) ||
                (p.left != null && q.left == null) ||
                (p.left == null && q.left != null) ) {
            answer = false;
            return ;
        }
    }

}
