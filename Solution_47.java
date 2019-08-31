/*
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/
import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(nums));
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0) {
            return ans;
        } else if ( nums.length == 1 ) {
            List<Integer> unit = new ArrayList<>();
            unit.add(nums[0]);
            ans.add(unit);
            return ans;
        } else if ( nums.length == 2 ) {
            if ( nums[0] == nums[1] ) {
                List<Integer> unit = new ArrayList<>();
                unit.add(nums[1]);
                unit.add(nums[0]);
                ans.add(unit);
                return ans;
            } else {
                List<Integer> unit1 = new ArrayList<>();
                List<Integer> unit2 = new ArrayList<>();
                unit1.add(nums[0]); unit2.add(nums[1]);
                unit1.add(nums[1]); unit2.add(nums[0]);
                ans.add(unit1); ans.add(unit2);
                return ans;
            }
        }
        Arrays.sort(nums);
        initializationMap(nums);
        solve ( map, nums,new ArrayList<>());
        return ans;

    }

    private void initializationMap(int[] nums) {
        int n = nums.length;
        for ( int i = 0 ; i < n ; i++ ) {
            int time = 1 ;
            while ( i < n - 1 && nums[i] == nums[i+1] ) {
                time++;
                i++;
            }
            map.put(nums[i], time);
        }
    }


    private void solve (Map<Integer, Integer> map, int[] nums , List<Integer> unit) {
       // System.out.println(unit);
        //System.out.println(map);
        if ( unit.size() + 1 == nums.length ) {
            int n = nums.length;
            List<Integer> temp = new ArrayList<>();
            temp.addAll(unit);
            for ( int i = 0 ; i < n ; i++ ) {
                if ( map.get(nums[i]) != 0 ) {
                    temp.add(nums[i]);
                    ans.add(temp);
                    break;
                }
            }
            int t = unit.get(unit.size()-1);
            //System.out.println("add before  "+unit + "  t = "+t+"    "+map);
            int value = map.get(t);
            map.replace(t,value + 1);
            unit.remove(unit.size()-1);
            //System.out.println("add after  "+unit + "  t = "+t+"    "+map);
            return;
        }

        int n = nums.length;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( map.get(nums[i]) != 0 ) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                } else {
                    unit.add(nums[i]);
                    int value = map.get(nums[i]);
                    map.replace(nums[i], value - 1 );
                    solve(map, nums, unit);
                }
            }
        }
        if ( !unit.isEmpty() ) {
            int t = unit.get(unit.size() - 1);
            int value = map.get(t);
            //System.out.println("before  "+unit + "  t = "+t+"    "+map);
            map.replace(t, value + 1);
            unit.remove(unit.size() - 1);
            //System.out.println("after  "+unit + "  t = "+t+"    "+map);
        }
    }

}