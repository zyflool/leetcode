/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */


import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        List<Integer> n3 = new ArrayList<>();
        List<Integer> n4 = new ArrayList<>();
        n1.add(2);
        n2.add(3); n2.add(4);
        n3.add(6); n3.add(5); n3.add(7);
        n4.add(4); n4.add(1); n4.add(8); n4.add(3);
        triangle.add(n1); triangle.add(n2); triangle.add(n3); triangle.add(n4);
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
    }

    private int answer = 2147483647;

    public int minimumTotal(List<List<Integer>> triangle) {
        if ( triangle.size() == 0 ) return 0;
        if ( triangle.size() == 1 ) return triangle.get(0).get(0);
        solve(triangle, 1, triangle.get(0).get(0), 0);
        return answer;
    }

    private void solve(List<List<Integer>> triangle, int floor, int cur, int pre) {
        if ( floor == triangle.size() ) {
            answer = Math.min(answer, cur);
            return;
        }
        if ( answer < cur ) return ;
        solve(triangle, floor+1, cur+triangle.get(floor).get(pre), pre);
        solve(triangle, floor+1, cur+triangle.get(floor).get(pre+1), pre+1);
    }
}
