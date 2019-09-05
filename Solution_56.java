/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        Solution solution = new Solution();
        int[][] answer = solution.merge(intervals);
        int n = answer.length;
        for (int i = 0; i < n; i++)
            System.out.println(answer[i][0] + " " + answer[i][1]);
    }

    class Bean implements Comparable {
        int[] interval;

        public Bean(int[] a) {
            this.interval = a;
        }

        @Override
        public int compareTo(Object o) {
            Bean t = (Bean) o;
            return this.interval[0] - t.interval[0];
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null)
            return null;
        List<Bean> intervalList = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++)
            intervalList.add(new Bean(intervals[i]));
        Collections.sort(intervalList);
        for (int i = 1; i < intervalList.size(); i++) {
            Bean last = intervalList.get(i - 1);
            Bean now = intervalList.get(i);
            if (last.interval[1] >= now.interval[0] && last.interval[1] < now.interval[1]) {
                int[] temp = new int[2];
                temp[0] = last.interval[0];
                temp[1] = now.interval[1];
                intervalList.remove(i - 1);
                intervalList.remove(i - 1);
                intervalList.add(i - 1, new Bean(temp));
                i--;
            } else if (last.interval[0] <= now.interval[0] && last.interval[1] >= now.interval[1]) {
                intervalList.remove(i);
                i--;
            }
        }
        int m = intervalList.size();
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i] = intervalList.get(i).interval;
        }
        return ans;

    }
}