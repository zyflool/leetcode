/*
52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:
输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

/*
对于主对角线（左上右下）
同一条对角线上的点 横坐标 - 纵坐标 = 同一个常数

对于次对角线（左下右上）
同一条对角线上的点 横坐标 + 纵坐标 = 同一个常数
 */
class Solution {

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(n));
    }

    int rows[];
    // "hill" diagonals
    int hills[];
    // "dale" diagonals
    int dales[];
    int n;

    int ans = 0;
    // queens positions
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == n) ans++;
                    // if not proceed to place the rest
                else backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return ans;
    }
}