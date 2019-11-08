/*
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。

例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
*/
/*
先序遍历从前到后所有点都是一个子树的根节点。
从左下角开始，找到当前还没确定的最左下的点。
当先序和中序起始点一样的时候，就是没有左子树的时候。
递归的时候上一层的根节点在这次递归的stop中。
我解释不清楚，反正就是这个亚子就对了。
 */
class Solution {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode answer = solution.buildTree(preorder, inorder);
        System.out.println(answer.val);
        System.out.println(answer.left.val+"   "+answer.right.val);
        System.out.println(answer.right.left.val+"   "+answer.right.right.val);
    }

    int pre;
    int in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder.length == 0 || inorder.length == 0 )    return null;
        if ( preorder.length == 1 )    return new TreeNode(preorder[0]);
        pre = 0;
        in = 0;
        return solve(preorder, inorder, (long) Integer.MIN_VALUE - 1);
    }

    private TreeNode solve(int[] preorder, int[] inorder, long stop) {
        if ( pre == preorder.length ) return null;
        if ( inorder[in] == stop )   {
            System.out.print(stop);
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        root.left = solve(preorder, inorder,root_val);
        root.right = solve(preorder, inorder,stop);
        return root;
    }

}
