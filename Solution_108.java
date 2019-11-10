/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val+"  "+root.right.val);
        System.out.println(root.left.left.val+"  "+root.right.left.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        switch ( n ) {
            case 0 :
                return null;
            case 1:
                return new TreeNode(nums[0]);
            case 2 :
                TreeNode n1 = new TreeNode(nums[0]);
                TreeNode n2 = new TreeNode(nums[1]);
                n1.right = n2;
                return n1;
            case 3 :
                TreeNode t1 = new TreeNode(nums[0]);
                TreeNode t2 = new TreeNode(nums[1]);
                TreeNode t3 = new TreeNode(nums[2]);
                t2.left = t1;
                t2.right = t3;
                return t2;
            default:
                return solve(nums, 0, n);
        }
    }

    private TreeNode solve (int[] nums, int left, int right) {  
        if ( left == right ) return null;
        TreeNode root = new TreeNode (nums[(left+right)/2]);
        root.left = solve(nums, left, (left+right)/2 );
        root.right = solve(nums, (left+right)/2+1, right);
        return root;
    }
}
