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
/*
位运算
使用二进制码标记每种排列

           [1,2,3]
0 -> 0 0 0 []
1 -> 0 0 1 [3]
2 -> 0 1 0 [2]
3 -> 0 1 1 [2,3]
4 -> 1 0 0 [1]
5 -> 1 0 1 [1,3]
6 -> 1 1 0 [1,2]
7 -> 1 1 1 [1,2,3]

*/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        System.out.println(solution.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
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
            int n = 1 << nums.length;
            for ( int i = 0; i < n ; i++ ) {
                List<Integer> unit = new ArrayList<>();
                if ( i != 0 ) {
                    for (int j = 0; j < nums.length; j++) {
                        if ( ( i >> j & 1 ) == 1 ) {
                            unit.add(nums[j]);
                        }
                    }
                }
                ans.add(unit);
            }
            return ans;
        }
    }

}