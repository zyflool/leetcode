/*
106. 从中序与后序遍历序列构造二叉树\
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
*/
/*
和105[1]一样的玄学做法，不过这个是从右下角开始的
 */
class Solution {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        Solution solution = new Solution();
        TreeNode answer = solution.buildTree(inorder, postorder);
        System.out.println(answer.val);
        System.out.println(answer.left.val+"   "+answer.right.val);
        System.out.println(answer.right.left.val+"   "+answer.right.right.val);
    }

    int post;
    int in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return buildTreeHelper(inorder, postorder, (long) Integer.MIN_VALUE - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, long stop) {
        if (post == -1) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int root_val = postorder[post--];
        TreeNode root = new TreeNode(root_val);
        root.right = buildTreeHelper(inorder, postorder, root_val);
        root.left = buildTreeHelper(inorder, postorder, stop);
        return root;
    }
}
