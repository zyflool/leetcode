/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1:
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true

示例 2:
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
*/
class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,50}
        };
        int target = 13;
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix,target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //二分
        //matrix[i][j] = list[i*n+j];
        //list[k] = matrix[k/n][k%n];
        int m = matrix.length;
        if ( m == 0 ) return false;
        int n = matrix[0].length;
        if ( n == 0 ) return false;

        return search(target, 0, m*n-1, matrix, n);

    }

    private boolean search (int target, int left, int right, int[][] matrix,int n) {
        if ( left > right ) return false;
        int leftn = matrix[left/n][left%n];
        if ( left == right ) {
            if ( leftn == target ) {
                return true;
            } else return false;
        } else {
            int mid = (left+right) / 2;
            int midn = matrix[mid/n][mid%n];
            if ( midn == target ) return true;
            else if ( target > midn ) return search(target, mid+1, right, matrix, n );
            else return search(target, left, mid-1, matrix, n);
        }
    }
}