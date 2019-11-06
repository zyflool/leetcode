/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3

说明:
如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[] {
                new TreeNode(2), new TreeNode(3), new TreeNode(3), new TreeNode(4),
                new TreeNode(5), new TreeNode(4), new TreeNode(5)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3]; n[1].right = n[4];
        n[2].left = n[5]; n[2].right = n[6];
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(n[0]));
    }

    private boolean answer = true;

    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        if ( root.right == null && root.left == null ) return true;
        if ( root.left != null && root.right == null ) return false;
        if ( root.left == null && root.right != null ) return false;
        if ( root.left.val != root.right.val ) return false;
        solve(root.left, root.right);
        return answer;
    }

    private void solve ( TreeNode left, TreeNode right ) {
        if ( left.left == null && right.right == null && left.right == null && right.left == null ) {
            //0 0 0 0
            return;
        }else if ( left.left == null && right.right == null ) {
            if ( left.right != null && right.left != null ) {
                //0 1 1 0
                if ( left.right.val == right.left.val ) {
                    solve(left.right, right.left);
                } else {
                    //o 1 1 0   but !=
                    answer = false;
                    return ;
                }
            } else {
                //0 1 0 0   or   0 0 1 0
                answer = false;
                return ;
            }
        } else if ( left.right == null && right.left == null ) {
            if ( left.left != null && right.right != null ) {
                //1 0 0 1
                if ( left.left.val == right.right.val ) {
                    solve(left.left, right.right);
                } else {
                    //1 0 0 1   but !=
                    answer = false;
                    return ;
                }
            } else {
                //1 0 0 0   or   0 0 0 1
                answer = false;
                return ;
            }
        } else if ( left.left == null ) {
            //0 1 0 1   or   0 0 0 1   or    0 0 1 1
            answer = false;
            return ;
        } else if ( left.right == null  ) {
            //1 0 1 0    or   1 0 1 1
            answer = false;
            return ;
        } else if ( right.right == null ) {
            // 1 1 1 0  or  1 1 0 0
            answer = false;
            return ;
        } else if ( right.left == null ) {
            //1 1 0 1
            answer = false;
            return;
        } else if ( left.left.val != right.right.val || left.right.val != right.left.val ) {
            //1 1 1 1   but!=
            answer = false;
            return ;
        } else {
            solve(left.left, right.right);
            solve(left.right, right.left);
        }
    }

}
