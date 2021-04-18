/*
229. 求众数 II
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

示例 1：
输入：[3,2,3]
输出：[3]

示例 2：
输入：nums = [1]
输出：[1]

示例 3：
输入：[1,1,1,3,3,2,2,2]
输出：[1,2]

提示：
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 */

/*
摩尔投票法： 选择所有人中投票数大于n/2的人（保证一定存在）
从头到尾遍历，选定第一个人先为候选人，后面的选择如果不一样，候选人的count--，如果一样就count++，
当count==0时，当前候选人在从头到当前这个位置m的票数不足m/2所以候选人不可选，在遍历下一个的时候选择下一位作为候选人再进行遍历

本题选择投票数大于n/3的人，所以候选人至多有两个，所以维护两个候选人的阵营进行比较和计数
遍历到某一个位置如果和某一个候选人相同，其计数加一，如果都不同全部count--。
得到两个候选人后再遍历计数每个候选人的票数，判断是否大于n/3
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_229 {

    public static void main(String[] args) {
        Solution_229 solution = new Solution_229();
        solution.majorityElement(new int[]{4,2,1,1});
    }

    public List<Integer> majorityElement(int[] nums) {
        int can1 = nums[0], can2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (can1 == n) {
                count1++;
                continue;
            } else if (can2 == n) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                can1 = n;
                count1++;
                continue;
            }
            if (count2 == 0) {
                can2 = n;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            count1 += (n == can1) ? 1 : 0;
            count2 += (n == can2) ? 1 : 0;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(can1);
        if (count2 > nums.length / 3 && can1 != can2) res.add(can2);
        return res;
    }
}
