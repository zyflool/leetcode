/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.combine(n, k));
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if ( k == 0 || n < k ) return ans;
        else if ( k == 1 ) {
            for ( int i = 1 ; i <= n ;i++ ) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                ans.add(temp);
            }
            return ans;
        } else {
            solve(new ArrayList<>(), 1, n, k);
            return ans;
        }
    }

    private void solve (List<Integer> cur, int begin, int n, int k) {
        if ( cur.size() == k ) {
            List<Integer> temp = new ArrayList<>(cur);
            ans.add(temp);
            cur.remove(cur.size()-1);
        } else {
            for ( int i = begin ; i <= n - (k - cur.size()) + 1 ; i++ ) {
                cur.add(i);
                solve(cur, i+1, n, k);
            }
            if ( !cur.isEmpty() ) {
                cur.remove(cur.size()-1);
            }
        }
    }
}