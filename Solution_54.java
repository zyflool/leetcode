/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2,   3,  4,  5,  6,  7,  8},
                { 9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56}
        };
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;//m行
        if (m == 0)
            return ans;
        int n = matrix[0].length;//n列
        if (m == 1) {
            for (int i = 0; i < n; i++)
                ans.add(matrix[0][i]);
            return ans;
        } else if (n == 1) {
            for (int i = 0; i < m; i++)
                ans.add(matrix[i][0]);
            return ans;
        } else {
            int mn = Math.min(m, n);
            for (int i = 0; i < (mn / 2); i++) {
                for (int j = i; j < n - 1 - i; j++)
                    ans.add(matrix[i][j]);
                for (int j = i; j < m - 1 - i; j++)
                    ans.add(matrix[j][n - 1 - i]);
                for (int j = n - 1 - i; j > i; j--)
                    ans.add(matrix[m - 1 - i][j]);
                for (int j = m - i - 1; j > i; j--)
                    ans.add(matrix[j][i]);
            }
            if (mn % 2 == 1) {
                int i = mn / 2;
                for (int j = i; j < n - 1 - i; j++)
                    ans.add(matrix[i][j]);
                for (int j = i; j < m - i; j++)
                    ans.add(matrix[j][n - 1 - i]);
            }
            return ans;
        }
    }
}