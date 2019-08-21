
/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
*/
import java.util.Arrays;
class Solution {
    public static void main ( String[] args ) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int ans;
        Arrays.sort(nums);
        int n = nums.length;
        ans = nums[n - 1] + nums[n - 2] +nums[n - 3];
        if ( ans < target )
            return ans;
        ans = nums[0] + nums[1] + nums[2];
        if ( ans > target )
            return ans;
        for (int i = 0 ; i < n - 2 ; i++ ) {
            int L = i + 1 ;
            int R = n - 1;
            while ( L < R ) {
                int sum = nums[i] + nums[L] + nums[R];
                if ( Math.abs( sum - target ) < Math.abs( ans - target ) )
                    ans = sum;
                if ( sum > target )
                    R--;
                else if ( sum < target)
                    L++;
                else return ans;
            }
        }
        return ans;
    }
}