/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。

示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> answer = solution.combinationSum(candidates, target);
        System.out.println(answer);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if( candidates.length == 0 )
            return ans;
        if (candidates.length == 1) {
            if ( target % candidates[0] == 0 ) {
                List<Integer> uni = new ArrayList<>();
                for ( int i = 0 ; i < target / candidates[0]; i++)
                    uni.add(candidates[0]);
                ans.add(uni);
                return ans;
            } else
                return ans;
        }
        Arrays.sort(candidates);
        solve (0, candidates, 0, target, new ArrayList<>());
        return ans;
    }

    private void solve (int exist, int[] candidates, int begin, int target, List<Integer> unit) {
        if ( exist == target ) {
            List<Integer> anew = new ArrayList<>();
            anew.addAll(unit);
            ans.add(anew);
            unit.remove(unit.size()-1);
            return;
        }
        int n = candidates.length;
        for ( int i = begin ; i < n ; i++ ) {
            int tmp = exist + candidates[i];
            if ( tmp > target && i == begin ) {
                if ( !unit.isEmpty() )
                    unit.remove(unit.size()-1);
                return ;
            } else if ( tmp > target ) {
                if ( !unit.isEmpty() )
                    unit.remove(unit.size()-1);
                return ;
            } else {
                unit.add(candidates[i]);
                solve(tmp,candidates,i, target,unit);
            }
        }
        if ( !unit.isEmpty() )
            unit.remove(unit.size()-1);
    }
}