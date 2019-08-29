/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
*/
class Solution {


    public static void main(String[] args) {
        int[] height = new int[] { 5,2,1,2,1,5};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));
    }

    public int trap(int[] height) {
        int l = height.length;
        int sum = 0;
        int[] max_left = new int[l];
        int[] max_right = new int[l];
        for ( int i = 1 ; i < l - 1 ; i++ )
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        for ( int i = l - 2 ; i >= 1 ; i-- )
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        for ( int i = 1 ; i < l - 1 ; i++ ) {
            int min = Math.min(max_left[i], max_right[i]);
            if ( min > height[i] )
                sum += min - height[i];
        }
        return sum;
    }
}