/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:
X X X X
X O O X
X X O X
X O X X

运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
 */

public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Solution solution = new Solution();
        solution.solve(board);
        for ( int i = 0 ; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {

        int height = board.length;
        if ( height == 0 )
            return;
        int width = board[0].length;
        if ( width == 0 )
            return;

        if ( width == 1 && height == width )
            return;

        boolean[][] lived = new boolean[height][width];

        for ( int j = 1 ; j < width - 1 ; j++ ) {
            if ( board[0][j] == 'O' )
                dfs(0, j, board, lived);

            if ( board[height-1][j] == 'O' )
                dfs(height-1, j, board, lived);
        }

        for ( int i = 1 ; i < height-1 ; i++ ) {
            if ( board[i][0]=='O' )
                dfs(i, 0, board, lived);

            if ( board[i][width-1] == 'O' )
                dfs(i, width-1, board, lived);
        }

        for ( int i = 1 ; i < height-1 ; i++ ) {
            for ( int j = 1 ; j < width-1 ; j++ ) {
                if ( !lived[i][j] )
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs ( int i, int j, char[][] board, boolean[][] lived ) {

        if ( board[i][j]=='X' || lived[i][j] )
            return;

        lived[i][j]=true;

        if ( i > 0 )
            dfs(i-1, j, board, lived);
        if ( i < board.length-1 )
            dfs(i+1, j, board, lived);
        if ( j > 0 )
            dfs(i, j - 1, board, lived);
        if ( j < board[0].length - 1 )
            dfs(i, j+1, board, lived);
    }

    private boolean isLive(int i, int j, char[][] board) {
        if ( board[i][j] != 'O' )
            return false;

        if ( i==0 || j==0 || i==board.length-1 || j==board[0].length-1 )
            return true;

        board[i][j]='#'; //待定

        return isLive(i+1,j,board)
                || isLive(i-1,j,board)
                || isLive(i,j+1,board)
                || isLive(i,j-1,board);
    }

}