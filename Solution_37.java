/*
37. 解数独
编写一个程序，通过已填充的空格来解决数独问题。
一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
一个数独。
答案被标成红色。

Note:
给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
在真实的面试中遇到过这道题？
*/
class Solution {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] block = new int[9];
        int[][] emptyArr = new int[82][3];

        pre(board, emptyArr, row, col, block);
        solveSudoku(board, emptyArr, 0, row, col, block);
    }

    private static char convert(int x) {
        switch (x) {
            case 0b000000001:
                return '1';
            case 0b000000010:
                return '2';
            case 0b000000100:
                return '3';
            case 0b000001000:
                return '4';
            case 0b000010000:
                return '5';
            case 0b000100000:
                return '6';
            case 0b001000000:
                return '7';
            case 0b010000000:
                return '8';
            case 0b100000000:
                return '9';
            default:
                return '.';
        }
    }

    private static void pre(char[][] board, int[][] emptyArr, int[] row, int[] col, int[] block) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int blockIndex = i / 3 * 3 + j / 3;
                if (board[i][j] != '.') {
                    int num = 1<<(board[i][j]-'1');
                    row[i] |= num;
                    col[j] |= num;
                    block[blockIndex] |= num;
                } else {
                    emptyArr[index][0] = i;
                    emptyArr[index][1] = j;
                    emptyArr[index][2] = blockIndex;
                    index++;
                }
            }
        }
        emptyArr[index][0] = -1;
        emptyArr[index][1] = -1;
        emptyArr[index][2] = -1;
    }

    public static boolean solveSudoku(char[][] board, int[][] emptyArr, int emptyIndex, int[] row, int[] col, int[] block) {
        if (emptyArr[emptyIndex][0] == -1) {
            return true;
        }

        int i = emptyArr[emptyIndex][0];
        int j = emptyArr[emptyIndex][1];
        int blockIndex = emptyArr[emptyIndex][2];
        int cur = 0b111111111^(row[i] | col[j] | block[blockIndex]);
        while (cur != 0) {
            int next = cur & (cur - 1);
            int val = cur ^ next;
            row[i] |= val;
            col[j] |= val;
            block[blockIndex] |= val;
            board[i][j] = convert(val);
            if (solveSudoku(board, emptyArr, (emptyIndex + 1), row, col, block)) {
                return true;
            } else {
                row[i] ^= val;
                col[j] ^= val;
                block[blockIndex] ^= val;
            }
            cur = next;
        }
        return false;
    }
}