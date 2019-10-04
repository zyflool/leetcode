/*
88. 合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/
class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(nums1,3,nums2,3);
        for ( int i = 0 ; i < nums1.length ; i++ )
        System.out.print(nums1[i]+" ");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length;
        int[] temp = new int[l];
        for ( int i = 0 ; i < l ; i++ )
            temp[i] = nums1[i];
        int i = 0;
        int j = 0;
        int k = 0;
        while ( i < m && j < n ) {
            if ( temp[i] < nums2[j] ) {
                nums1[k] = temp[i];
                i++;
                k++;
            } else {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        while ( i < m ) {
            nums1[k++] = temp[i++];
        }
        while ( j < n ) {
            nums1[k++] = nums2[j++];
        }
    }
}