/*
268. 缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:
输入: [3,0,1]
输出: 2

示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
*/
/*
位运算
对一个数进行两次完全相同的异或运算会得到原来的数
 */
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{44,26,34,25,23,42,0,43,38,14,47,19,49,6,16,41,24,35,10,4,32,5,8,15,31,3,46,22,2,30,28,37,1,21,39,45,9,48,36,17,7,27,18,29,13,40,11,20,12};
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
            missing = missing ^ i ^ nums[i];
        return missing;
    }

}