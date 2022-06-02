import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 2285. 道路的最大总重要性
 * 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 * 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 *
 * 示例 1：
 * 输入：n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
 * 输出：43
 * 解释：上图展示了国家图和每个城市被安排的值 [2,4,5,3,1] 。
 * - 道路 (0,1) 重要性为 2 + 4 = 6 。
 * - 道路 (1,2) 重要性为 4 + 5 = 9 。
 * - 道路 (2,3) 重要性为 5 + 3 = 8 。
 * - 道路 (0,2) 重要性为 2 + 5 = 7 。
 * - 道路 (1,3) 重要性为 4 + 3 = 7 。
 * - 道路 (2,4) 重要性为 5 + 1 = 6 。
 * 所有道路重要性之和为 6 + 9 + 8 + 7 + 7 + 6 = 43 。
 * 可以证明，重要性之和不可能超过 43 。
 *
 * 示例 2：
 * 输入：n = 5, roads = [[0,3],[2,4],[1,3]]
 * 输出：20
 * 解释：上图展示了国家图和每个城市被安排的值 [4,3,2,5,1] 。
 * - 道路 (0,3) 重要性为 4 + 5 = 9 。
 * - 道路 (2,4) 重要性为 2 + 1 = 3 。
 * - 道路 (1,3) 重要性为 3 + 5 = 8 。
 * 所有道路重要性之和为 9 + 3 + 8 = 20 。
 * 可以证明，重要性之和不可能超过 20 。
 *
 * 提示：
 * 2 <= n <= 5 * 104
 * 1 <= roads.length <= 5 * 104
 * roads[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 没有重复道路。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumImportance(5,new int[][]{{0,3},{2,4},{1,3}});
    }

    public long maximumImportance1(int n, int[][] roads) {
        int[] nums = new int[n];
        for (int[] road : roads) {
            ++nums[road[0]];
            ++nums[road[1]];
        }
        Arrays.sort(nums); // 排序
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans += (long) nums[i - 1] * i;
        }
        return ans;
    }

    public void getNewPosition(List<Integer> queue, int position, int[] count) { // 二分排序
        if (position == 0 || count[queue.get(position)] <= count[queue.get(position-1)]) {
            return;
        }
        int l = 0, r = position - 1;
        int goal = -1;
        while (l < r) {
            int m = (l+r) / 2;
            if (count[queue.get(m)] > count[queue.get(position)]) {
                if (l == m) {
                    goal = r;
                    break;
                }
                l = m;
            } else {
                r = m;
            }
        }
        if (goal == -1)
            goal = l;
        int pre = queue.remove(position);
        queue.add(goal, pre);
    }

    public long maximumImportance(int n, int[][] roads) {
        long sum = 0;
        int[] count = new int[n];
        List<Integer> queue = new ArrayList<>();
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;

            int n0 = queue.indexOf(road[0]);
            int n1 = queue.indexOf(road[1]);
            if (n0 != -1 && n1 != -1) {
                if (n0 < n1) {
                    getNewPosition(queue, n0, count);
                    getNewPosition(queue, n1, count);
                } else {
                    getNewPosition(queue, n1, count);
                    getNewPosition(queue, n0, count);
                }
            } else if (n0 == -1 && n1 == -1) {
                queue.add(road[0]);
                queue.add(road[1]);
            } else if (n0 == -1) {
                getNewPosition(queue, n1, count);
                queue.add(road[0]);
            } else {
                getNewPosition(queue, n0, count);
                queue.add(road[1]);
            }
        }
        for (int i = 0 ; i < n ; i++) {
            sum += (long) (n - queue.indexOf(i)) * count[i];
        }
        return sum;
    }
}
