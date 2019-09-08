/*
60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。

示例 1:
输入: n = 3, k = 3
输出: "213"

示例 2:
输入: n = 4, k = 9
输出: "2314"
*/
import java.util.ArrayList;
import java.util.List;


class Solution {

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        Solution solution = new Solution();
        String answer = solution.getPermutation(n, k);
        System.out.println(answer);
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre, factorial);
    }

    /**
     * @param nums 要填的数字
     * @param used 当前数是否被使用过
     * @param n 排列的长度
     * @param k 要找第几个
     * @param depth 遍历的深度/已排列的长度
     * @param pre 动态排列临时排列
     * @param factorial 阶乘表
     * @return
     */

    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre, int[] factorial) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial[n - 1 - depth];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps < k) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre, factorial);
        }
        // 如果参数正确的话，代码不会走到这里
        throw new RuntimeException("参数错误");
    }
}