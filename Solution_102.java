/*
102. 二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        TreeNode[] n = new TreeNode[] {
                new TreeNode(3), new TreeNode(9), new TreeNode(20), new TreeNode(15),
                new TreeNode(7)
        };
        n[0].left = n[1]; n[0].right = n[2];
        n[2].left = n[3]; n[2].right = n[4];
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(n[0]));
    }

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null )
            return answer;
        solve(root, 0);
        return answer;
    }

    private void solve ( TreeNode root, int floor ) {
        if ( answer.size() == floor )
            answer.add(new ArrayList<>());
        answer.get(floor).add(root.val);
        if ( root.left != null )
            solve(root.left,floor+1);
        if ( root.right != null )
            solve(root.right, floor+1);
    }
}
