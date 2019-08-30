import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
46. 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums).size());
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if ( nums.length == 0 )
            return ans;
        else if ( nums.length == 1 ) {
            List<Integer> unit = new ArrayList<>();
            unit.add(nums[0]);
            ans.add(unit);
            return ans;
        } else if ( nums.length == 2 ) {
            List<Integer> unit1 = new ArrayList<>();
            List<Integer> unit2 = new ArrayList<>();
            unit1.add(nums[0]); unit1.add(nums[1]);
            unit2.add(nums[1]); unit2.add(nums[0]);
            ans.add(unit1); ans.add(unit2);
            return ans;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ )
            map.put(nums[i],false);
        solve(map,new ArrayList<>(), nums);
        return ans;
    }

    private void solve (Map<Integer,Boolean> map, List<Integer> unit, int[] nums ) {
        System.out.println(unit);
        if ( unit.size() + 1 == nums.length ) {
            for ( int i = 0 ; i < nums.length ; i++ ) {
                if ( !map.get(nums[i]) ){
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(unit);
                    temp.add(nums[i]);
                    ans.add(temp);
                    break;
                }
            }
            int t = unit.get(unit.size() - 1 );
            map.replace(t, false);
            unit.remove(unit.size()-1);
            return;
        }

        int n = nums.length;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( !map.get(nums[i]) ) {
                unit.add(nums[i]);
                map.replace(nums[i],true);
                solve(map,unit,nums);
            }
        }
        if ( !unit.isEmpty() ) {
            int t = unit.get(unit.size() - 1);
            map.replace(t, false);
            unit.remove(unit.size() - 1);
        }
    }
}