/*
149. 直线上最多的点数
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:
输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4

示例 2:
输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6


[[1,1],[2,1],[2,2],[1,4],[3,3]]
^
|
|  o
|       o
|     o
|  o  o
+------------------->
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][] {{2,3},{3,3},{-5,3}};
        System.out.println(solution.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        if (points == null)
            return 0;
        if (points.length <= 2)
            return points.length;
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            long dx = x - points[i - 1][0];
            long dy = y - points[i - 1][1];
            int count = 0;
            if (dx == 0 && dy == 0) { // 相同的点
                for (int[] point : points) {
                    if (point[0] != x || point[1] != y)
                        continue;
                    count++;
                }
            } else { // 不相同的点
                for (int[] point : points) {
                    if ((point[0] - x) * dy != (point[1] - y) * dx)
                        continue;
                    count++;
                }
            }
            res = Math.max(res, count);
        }
        int diag = 0;
        for (int[] point : points) {
            if (point[0] != point[1])
                continue;
            diag++;
        }
        return Math.max(res, diag);
    }


}