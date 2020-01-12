/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。

示例:
输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if ( nums.length <= 1 )
            return nums.length;
        Arrays.sort(nums);
        int m = nums[0];
        int ans = Integer.MIN_VALUE;
        int count = 1;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( nums[i] == nums[i-1]) {
                while ( i < nums.length && nums[i] != nums[i-1] ) i++;
            } else if ( nums[i] == m+1 ) {
                count++;
                m++;
            } else {
                m = nums[i];
                count = 1;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}