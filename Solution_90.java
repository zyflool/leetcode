/*
90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
/*
回溯
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(nums));
    }

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return ans;
        if ( n == 1 ) {
            List<Integer> unit1 = new ArrayList<>();
            List<Integer> unit2 = new ArrayList<>();
            ans.add(unit1);
            unit2.add(nums[0]);
            ans.add(unit2);
            return ans;
        } else {
            Arrays.sort(nums);
            solve(nums,-1,new ArrayList<>());
            return ans;
        }
    }

    private void solve(int[] nums, int last, List<Integer> unit) {
        List<Integer> temp = new ArrayList<>(unit);
        ans.add(temp);
        if ( unit.size() == nums.length ) {
            unit.remove(unit.size()-1);
            return;
        }
        for ( int i = last + 1 ; i < nums.length ; i++ ) {
            int j = i;
            while ( j >= 0 && j < nums.length -1 && nums[j] == nums[j+1] ) {
                j++;
            }
            unit.add(nums[j]);
            solve(nums, i, unit);
            i = j;
        }
        if ( !unit.isEmpty() ) {
            unit.remove(unit.size()-1);
        }
    }
}