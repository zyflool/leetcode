/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[]{
                new TreeNode(5),
                new TreeNode(4),
                new TreeNode(8),
                new TreeNode(11),
                new TreeNode(13),
                new TreeNode(4),
                new TreeNode(7),
                new TreeNode(2),
                new TreeNode(5),
                new TreeNode(1)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[1].left = n[3];
        n[2].left = n[4]; n[2].right = n[5];
        n[3].left = n[6]; n[3].right = n[7];
        n[5].left = n[8]; n[5].right = n[9];
        int sum = 22;
        Solution solution = new Solution();
        System.out.println(solution.pathSum(n[0],sum));

    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if ( root == null ) return ans;
        List<Integer> unit = new ArrayList<>();
        unit.add(root.val);
        solve(root, sum - root.val, unit);
        return ans;
    }


    private void solve (TreeNode root, int sum, List<Integer> unit) {
        System.out.println(root.val + "  "+sum+"  "+unit.toString());
        if ( sum == 0 && root.right == null && root.left == null) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(unit);
            ans.add(temp);
        }
        if (root.right != null) {
            unit.add(root.right.val);
            solve(root.right, sum - root.right.val, unit);
            unit.remove(unit.size()-1);
        }
        if (root.left != null) {
            unit.add(root.left.val);
            solve(root.left, sum - root.left.val, unit);
            unit.remove(unit.size()-1);
        }
    }
}
