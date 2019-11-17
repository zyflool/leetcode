/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为链表。
例如，给定二叉树
    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
/*
交换左右子树，深度优先遍历右子树，然后把左子树放到右子树叶子节点后，清空左子树，继续遍历
 */
class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{
                new TreeNode(1),
                new TreeNode(2),
                new TreeNode(3),
                new TreeNode(4),
                new TreeNode(5),
                new TreeNode(6),
                new TreeNode(7),
                new TreeNode(8),
                new TreeNode(9),
                new TreeNode(10)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3]; n[1].right = n[4];
        n[2].left = n[5]; n[2].right = n[6];
        n[6].right = n[7]; n[7].right = n[8];
        n[8].right = n[9];
        Solution solution = new Solution();
        solution.flatten(n[0]);
        TreeNode N = n[0];
        while ( N != null ) {
            System.out.print(N.val+" ");
            N = N.right;
        }
    }

    public void flatten(TreeNode root) {
        if ( root == null ) return ;
        if ( root.left != null ) {
            if ( root.right == null ) {
                root.right = root.left;
                root.left = null;
                flatten(root.right);
            } else {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                flatten(root.right);
                temp = root.right;
                while ( temp.right != null ) temp = temp.right;
                temp.right = root.left;
                root.left = null;
                flatten(temp.right);
            }
        } else {
            if ( root.right != null)
                flatten(root.right);
        }
    }
}
