/*
45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

说明:
假设你总是可以到达数组的最后一个位置。
*/
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }

    public int jump(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int curMaxIndex = nums[0];
        int preMaxMaxIndex = nums[0];
        int minJump = 1;
        for(int i=1; i<nums.length; i++) {
            if(i > curMaxIndex){
                minJump++;
                curMaxIndex = preMaxMaxIndex;
            }
            if(preMaxMaxIndex < nums[i]+i) {
                preMaxMaxIndex = nums[i] + i;
            }
        }
        return minJump;
    }
}