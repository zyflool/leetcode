/*
994. 腐烂的橘子
在给定的网格中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

示例 1：
输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4

示例 2：
输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

示例 3：
输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。

提示：
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为 0、1 或 2
 */
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[][] grid = { {2,1,1},{1,1,0},{0,1,1} };

        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;  //行数
        if ( n == 0 ) return 0;
        int m = grid[0].length; //列数

        List<Integer> q = new ArrayList<>();
        Set<Integer> node = new HashSet<>();

        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < m ; j++ ) {
                if ( grid[i][j] == 1 ) {
                    node.add(i*m+j);
                } else if ( grid[i][j] == 2 ) {
                    q.add(i*m+j);
                }
            }
        }

        if ( node.isEmpty() )
            return 0;
        else {
            int time = -1;
            while ( !q.isEmpty() ) {
                time++;
                List<Integer> temp = new ArrayList<>();
                while ( !q.isEmpty() ) {
                    int cur = q.get(0);
                    q.remove(0);
                    int i = cur / m, j = cur % m;

                    if (i > 0 && node.contains((i - 1) * m + j)) {
                        node.remove((i - 1) * m + j);
                        temp.add((i - 1) * m + j);
                    }
                    if (i < n - 1 && node.contains((i + 1) * m + j)) {
                        node.remove((i + 1) * m + j);
                        temp.add((i + 1) * m + j);
                    }
                    if (j > 0 && node.contains(i * m + (j - 1))) {
                        node.remove(i * m + (j - 1));
                        temp.add(i * m + (j - 1));
                    }
                    if (j < m - 1 && node.contains(i * m + (j + 1))) {
                        node.remove(i * m + (j + 1));
                        temp.add(i * m + (j + 1));
                    }
                }
                q.addAll(temp);
            }
            if ( node.isEmpty())
                return time;
            else return -1;
        }
    }
}