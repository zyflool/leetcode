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
普通做法：分治
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ( postorder.length == 0 || inorder.length == 0 )    return null;
        if ( inorder.length == 1 )    return new TreeNode(postorder[0]);
        return solve(inorder, postorder, 0, 0, postorder.length);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int inbegin, int postbegin, int length) {

        if ( length == 0 )    return null;
        TreeNode root = new TreeNode(postorder[postbegin+length-1]);
        //i是根节点的位置
        int i = 0;
        while ( postorder[postbegin+length-1] != inorder[inbegin+i] )    i++;

        root.left = solve(inorder, postorder,inbegin, postbegin, i);
        root.right = solve(inorder, postorder, inbegin + i + 1, postbegin + i,length - i - 1);
        return root;
    }
}
