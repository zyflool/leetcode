/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
class Solution {

    public static void main(String[] args) {
        int n = 6;
        Solution solution = new Solution();
        int[][] answer = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        if ( n == 0 ) {
            return new int[0][0];
        }
        int[][] ans = new int[n][n];
        if ( n == 1 ) {
            ans[0][0] = 1;
        } else {
            int count = 1;
            for (int i = 0; i < (n / 2); i++) {
                for (int j = i; j < n - 1 - i; j++)
                    ans[i][j] = count++;
                for (int j = i; j < n - 1 - i; j++)
                    ans[j][n - 1 - i] = count++;
                for (int j = n - 1 - i; j > i; j--)
                    ans[n - 1 - i][j] = count++;
                for (int j = n - i - 1; j > i; j--)
                    ans[j][i] = count++;
            }
            if (n % 2 == 1) {
                int i = n / 2;
                for (int j = i; j < n - 1 - i; j++)
                    ans[i][j] = count++;
                for (int j = i; j < n - i; j++)
                    ans[j][n - 1 - i] = count++;
            }
        }
        return ans;
    }
}