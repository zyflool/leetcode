/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public static void main ( String[] args ) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5}; //-5, -4,-3,-2,1,3,3,5
        int target = -11;
        List<List<Integer>> ans= fourSum(nums, target);
        for (int i = 0 ; i < ans.size(); i++ ){
            System.out.println(ans.get(i).toString());
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for ( int  i = 0 ; i < n - 3 ; i++ ) {
            if ( i - 1 >= 0 && nums[i] == nums[i-1] )
                continue;
            for ( int  j = i + 1 ; j < n - 2 ; j++ ) {
                if ( j - 1 >= i + 1 && nums[j] == nums[j-1] )
                    continue;
                int L = j + 1 ;
                int R = n - 1;
                while ( L < R ) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if ( sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[L]);
                        tmp.add(nums[R]);
                        ans.add(tmp);
                        while (L < R && nums[L] == nums[L + 1])
                            L++;
                        while (L < R && nums[R] == nums[R - 1])
                            R--;
                        L++;
                        R--;
                    } else if ( sum > target ) {
                        while (L < R && nums[R] == nums[R - 1])
                            R--;
                        R--;
                    } else if ( sum < target ) {
                        while (L < R && nums[L] == nums[L + 1])
                            L++;
                        L++;
                    }
                }
            }
        }
        return ans;
    }
}