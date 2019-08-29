/*
41. 缺失的第一个正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:
输入: [1,2,0]
输出: 3

示例 2:
输入: [3,4,-1,1]
输出: 2

示例 3:
输入: [7,8,9,11,12]
输出: 1

说明:
你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
*/
class Solution {


    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for ( int i = 0 ; i < n ; i++ ) {
            while ( nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]-1] ) {
                swap(nums,nums[i]-1,i);
            }
        }

        for ( int i = 0 ; i < n ; i++ ) {
            if ( nums[i] - 1 != i )
                return i + 1;
        }
        return n + 1;
    }

    private void swap (int[] nums, int a, int b) {
        if ( a == b ) return ;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}