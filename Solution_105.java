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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder.length == 0 || inorder.length == 0 )    return null;
        if ( preorder.length == 1 )    return new TreeNode(preorder[0]);
        return solve(preorder, inorder, 0,preorder.length, 0, inorder.length);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int prebegin, int preend, int inbegin, int inend) {
        if ( prebegin == preend )    return null;
        TreeNode root = new TreeNode(preorder[prebegin]);
        //i是根节点的位置
        int i = inbegin;
        while ( preorder[prebegin] != inorder[i] )    i++;

        root.left = solve(preorder, inorder,prebegin+1, prebegin+1+i-inbegin, inbegin, i);
        root.right = solve(preorder, inorder, preend-inend+i+1, preend, i+1, inend);
        return root;
    }

}
