/*
 
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        if ( l == 1 )
            return nums[0];
        int Max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < l ; i++ ) {
            int tmp = nums[i];
            if ( Max < tmp )
                Max = tmp;
            for ( int j = 1 ; j < l - i ; j++ ) {
                tmp += nums[i+j];
                if ( Max < tmp )
                    Max = tmp;
            }
        }
        return Max;
    }
}
