/*
98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true

示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4
*/
class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[] {
                new TreeNode(87),  new TreeNode(84),  new TreeNode(94),  new TreeNode(79),  new TreeNode(77),
                new TreeNode(-82), new TreeNode(70),  new TreeNode(38),  new TreeNode(36),  new TreeNode(45),
                new TreeNode(22),  new TreeNode(18),  new TreeNode(24),  new TreeNode(14),  new TreeNode(8),
                new TreeNode(-93), new TreeNode(6),   new TreeNode(-37), new TreeNode(-21), new TreeNode(4),
                new TreeNode(-32), new TreeNode(-15), new TreeNode(-42), new TreeNode(-63), new TreeNode(-70),
                new TreeNode(-78), new TreeNode(75),  new TreeNode(7),   new TreeNode(-96), new TreeNode(-98)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3];
        n[3].left = n[4];
        n[4].left = n[5];
        n[5].left = n[6];
        n[6].left = n[7];
        n[7].left = n[8]; n[7].right = n[9];
        n[8].left = n[10];
        n[10].left = n[11]; n[10].right = n[12];
        n[11].left = n[13];
        n[13].left = n[14];
        n[14].left = n[15];
        n[15].left = n[16];
        n[16].left = n[17];
        n[17].left = n[18]; n[17].right = n[19];
        n[18].left = n[20];
        n[20].left = n[21];
        n[21].left = n[22];
        n[22].left = n[23];
        n[23].left = n[24];
        n[24].left = n[25];
        n[25].left = n[26];
        n[26].left = n[27];
        n[27].left = n[28];
        n[28].left = n[29];
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(n[0]));
    }

    private boolean answer = true;

    public boolean isValidBST (TreeNode root) {
        if ( ( root == null ) || ( root.left == null && root.right == null ) )
            return true;
        else if ( root.left == null )  {
            if ( root.right.val > root.val ) {
                if ( root.right.left != null ) {
                    solve( root.right.left, root.val, root.right.val);
                }
                if ( root.right.right != null ) {
                    solve( root.right.right, root.right.val, -2147483648);
                }
                return answer;
            } else return false;
        } else if  ( root.right == null ) {
            if ( root.left.val < root.val ) {
                if ( root.left.left != null ) {
                    solve( root.left.left, 2147483647, root.left.val);
                }
                if ( root.left.right != null ) {
                    solve( root.left.right, root.left.val, root.val);
                }
                return answer;
            } else return false;
        } else if ( root.right.val <= root.val ) {
            return false;
        } else if ( root.left.val >= root.val ) {
            return false;
        } else {
            if ( root.left.left != null ) { //左孩子的左孩子，没有最小值
                solve( root.left.left, 2147483647, root.left.val);
            }
            if ( root.left.right != null ) { //左孩子的右孩子，最小为左孩子，最大为根节点
                solve( root.left.right, root.left.val, root.val);
            }
            if ( root.right.left != null ) { //右孩子的左孩子，最小为根节点，最大为右孩子
                solve( root.right.left, root.val, root.right.val);
            }
            if ( root.right.right != null ) { //右孩子的右孩子，没有最大值
                solve( root.right.right, root.right.val, -2147483648);
            }
            return answer;
        }
    }

    public void solve ( TreeNode cur, int min, int max) {
        if (min == 2147483647) {
            if (cur.val >= max)
                answer = false;
        } else if (max == -2147483648) {
            if (cur.val <= min)
                answer = false;
        } else if (cur.val >= max || cur.val <= min) {
            answer = false;
        }
        if (cur.left != null) {
            if (max != -2147483648)
                solve(cur.left, min, Math.min(cur.val, max));
            else
                solve(cur.left, min, cur.val);
        }
        if (cur.right != null) {
            if (min != 2147483647)
                solve(cur.right, Math.max(cur.val, min), max);
            else
                solve(cur.right, cur.val, max);
        }
    }
}
