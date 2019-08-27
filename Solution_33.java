/*
33. 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。

示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4

示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
*/
class Solution {

    public static void main ( String[] args ) {
        int[] nums = new int[]{1,3,5};
        int target = 1;
        System.out.println(search(nums,target));
    }

    public static int SearchSmallest(int left, int right, int[] nums) {
        if (nums[left] < nums[right])
            return 0;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) {
            if (nums[0] != target)
                return -1;
            else return 0;
        }
        int mini = SearchSmallest(0,nums.length-1,nums);
        if ( nums[mini] > target )
            return -1;
        else if ( mini != 0 && nums[mini-1] < target )
            return -1;
        else if ( mini == 0 )
            return SearchTarget(0, nums.length-1, nums, target);
        else if ( target >= nums[0] )
            return SearchTarget(0 , mini, nums, target);
        else return SearchTarget( mini, nums.length-1, nums, target);
    }


    public static int SearchTarget (int left, int right, int[] nums, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        } else if ( left + 1 == right ) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }else
                return -1;
        } else {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                return SearchTarget(left, mid, nums, target);
            else return SearchTarget(mid + 1, right, nums, target);
        }
    }
}