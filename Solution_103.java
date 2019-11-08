/*
103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
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
        System.out.println(solution.zigzagLevelOrder(n[0]));
    }

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if ( root == null )
            return answer;
        solve(root, 0);
        return answer;
    }

    private void solve ( TreeNode root, int floor ) {
        if ( answer.size() == floor )
            answer.add(new ArrayList<>());
        if ( floor % 2 == 0 )
            answer.get(floor).add(root.val);
        else
            answer.get(floor).add(0,root.val);
        if ( root.left != null )
            solve(root.left,floor+1);
        if ( root.right != null )
            solve(root.right, floor+1);
    }
}
