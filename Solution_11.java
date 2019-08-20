/*
11. 盛最多水的容器
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且n的值至少为2。
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。

示例:
输入: [1,8,6,2,5,4,8,3,7]
输出: 49
*/
class Solution {
    public static void main ( String[] args ) {
        int[] height = new int[] { 1,8,6,2,5,4,8,3,7 };
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while ( l < r ) {
            max = Math.max(max, (r-l) * Math.min(height[r],height[l]));
            if ( height[r] > height[l] )
                l++;
            else r--;
        }
        return max;
    }
}