/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。

示例:
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
*/
/*
递归 剪枝:如果当前深度大于已找到的最小深度直接返回不再向下搜索
 */
class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{
                new TreeNode(3),
                new TreeNode(9),
                new TreeNode(20),
                new TreeNode(15),
                new TreeNode(7)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[2].left = n[3]; n[2].right = n[4];
        Solution solution = new Solution();
        System.out.println(solution.minDepth(n[0]));

    }

    private int answer = 2147483647;

    public int minDepth(TreeNode root) {
        if (root == null ) return 0;
        if ( root.left == null && root.right == null ) return 1;
        if ( root.left == null ) {
            solve(root.right, 2);
            return answer;
        }
        if ( root.right == null ) {
            solve(root.left, 2);
            return answer;
        }
        solve(root, 1);
        return answer;
    }

    private void solve(TreeNode root, int floor) {
        if ( floor > answer ) return ;
        if ( root.left == null && root.right == null )
            answer = Math.min(answer, floor);
        if ( root.left != null )
            solve(root.left, floor + 1);
        if ( root.right != null )
            solve(root.right, floor + 1);
    }
}
