/*
765. 情侣牵手
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。一次交换可选择任意两人，让他们站起来交换座位。
人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，
以此类推，最后一对是 (2N-2, 2N-1)。
这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

示例 1:
输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。

示例 2:
输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。

说明:
len(row) 是偶数且数值在 [4, 60]范围内。
可以保证row 是序列 0...len(row)-1 的一个全排列。
 */

/*
并查集
混杂在一起的情侣是一个并查集，一堆情侣中有n对，就需要调换n-1次才能实现（数学归纳法）
初始化将所有情侣放在各自对并查集中，然后两个两个遍历座位，
如果连续两个座位上不是一对情侣，或者不属于同一并查集，就需要调换（也就是说两边混杂在一起），则将两个并查集合并。
 */

import java.util.*;

public class Solution_765 {
    public static void main(String[] args) {
        Solution_765 solution = new Solution_765();
        System.out.println(solution.minSwapsCouples(new int[]{0,2,5,3,4,6,7,1,9,8}));
    }

    int[] f;

    public int find(int x) {
        return f[x] == x ? x : find(f[x] = f[f[x]]);
    }

    public int minSwapsCouples(int[] row) {
        f = new int[row.length];
        for (int i = 0; i < row.length; i+=2) {
            f[i] = i;
            f[i+1] = i;
        }

        for (int i = 0; i < row.length; i += 2) {
            int a = find(row[i]);
            int b = find(row[i + 1]);
            if (a != b)
                f[a] = b;
        }
        Map<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < row.length; i++) {
            int t = find(i);
            if (res.getOrDefault(t, -1) == -1) {
                res.put(t, 1);
            } else {
                res.put(t, res.get(t) + 1);
            }
        }

        Set<Integer> fs = res.keySet();
        int ans = 0;
        for (Integer a : fs) {
            ans += res.get(a) / 2 - 1;
        }
        return ans;
    }
}
