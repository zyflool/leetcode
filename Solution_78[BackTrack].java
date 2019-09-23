/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.subsets(nums));
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if ( nums.length == 0 )
            return ans;
        else if ( nums.length == 1 ) {
            ans.add(new ArrayList<>());
            for ( int i = 0 ; i < nums.length ; i++ ) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                ans.add(temp);
            }
            return ans;
        } else {
            solve(new ArrayList<>(), 0, nums);
            return ans;
        }
    }

    private void solve (List<Integer> cur, int begin, int[] nums) {
        List<Integer> temp = new ArrayList<>(cur);
        ans.add(temp);
        if ( cur.size() == nums.length ) {
            cur.remove(cur.size()-1);
        } else if ( !cur.isEmpty() && cur.get(cur.size() -1) == nums[nums.length-1] ) {
            cur.remove(cur.size()-1);
        } else {
            int l = nums.length;
            for ( int i = begin ; i < l ; i++ ) {
                cur.add(nums[i]);
                solve(cur,i+1,nums);
            }
            if ( !cur.isEmpty() ) {
                cur.remove(cur.size()-1);
            }
        }
    }
}