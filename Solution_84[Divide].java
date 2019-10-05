/*
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

示例:

输入: [2,1,5,6,2,3]
输出: 10
*/
/*
分治
 */
class Solution {

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if( len == 0 ) return 0;
        return maxArea(heights, 0, len-1);
    }


    private int maxArea(int[] h, int left, int right) {
        if ( left == right ) return h[right];
        int min = left;
        boolean sorted = true;
        //找到区间最小的序号，并且检查区间内是否按从小到大排序的
        for ( int i = left+1 ; i <= right ; i++ ) {
            if ( h[i] < h[i-1] )
                sorted = false;
            if ( h[i] < h[min] )
                min = i;
        }
        //如果区间内从小到大递增，找最大面积并返回
        if ( sorted ) {
            int max = 0;
            for ( int i = left ; i <= right ; i++ )
                max = Math.max(max, h[i]*(right-i+1) );
            return max;
        }
        //如果区间不从小到大递增，从最小的分界左右两边分别找最大面积。
        int l = 0, r = 0;
        if ( min > left )
            l = maxArea(h, left, min-1);
        if ( min < right )
            r = maxArea(h, min+1, right);
        return Math.max(Math.max(l, r), h[min]*(right-left+1));
    }

}