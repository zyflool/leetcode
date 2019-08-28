/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> answer = solution.combinationSum2(candidates, target);
        System.out.println(answer);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if ( candidates.length == 0 )
            return ans;
        if ( candidates.length == 1 && candidates[0] != target )
            return ans;
        if ( candidates.length == 1 && candidates[0] == target ) {
            List<Integer> unit = new ArrayList<>();
            unit.add(candidates[0]);
            ans.add(unit);
            return ans;
        }
        Arrays.sort(candidates);
        solve(0,candidates,0,target,new ArrayList<>());
        return ans;
    }

    private void solve(int exist, int[] candidates, int begin, int target, List<Integer> unit) {
        if ( exist == target ) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(unit);
            ans.add(temp);
            unit.remove(unit.size()-1);
            return ;
        }
        int n = candidates.length;
        for ( int i = begin; i < n ; i++ ) {
            int tmp = exist + candidates[i];
            if ( tmp > target && i == begin ) {
                if ( !unit.isEmpty() )
                    unit.remove(unit.size()-1);
                return ;
            } else if ( tmp > target ) {
                if ( !unit.isEmpty() )
                    unit.remove(unit.size()-1);
                return;
            } else if ( i != begin && candidates[i] == candidates[i-1] ) {
                continue;
            } else {
                unit.add(candidates[i]);
                solve(tmp,candidates,i+1,target,unit);
            }
        }
        if ( !unit.isEmpty() )
            unit.remove(unit.size()-1);
    }
}