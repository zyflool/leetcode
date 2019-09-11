/*
65. 有效数字
验证给定的字符串是否可以解释为十进制数字。

例如:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：

数字 0-9
指数 - "e"
正/负号 - "+"/"-"
小数点 - "."
当然，在输入中，这些字符的上下文也很重要。
*/

/*
DFA算法
不是很懂
 */

class Solution {

    public static void main(String[] args) {
        String s = "..";
        Solution solution = new Solution();
        System.out.println(solution.isNumber(s));
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        char[] arr = s.toCharArray();
        int    len = arr.length;

        int[][] fsm = {
                {-1, 1, 9, -1, 2, 0},
                {-1, 1, 3, 4, -1, 8},
                {-1, 1, 9, -1, -1, -1},
                {-1, 5, -1, 4, -1, 8},
                {-1, 6, -1, -1, 7, -1},
                {-1, 5, -1, 4, -1, 8},
                {-1, 6, -1, -1, -1, 8},
                {-1, 6, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, 8},
                {-1, 5, -1, -1, -1, -1},
        };

        int state = 0;
        int point = 0;
        for (int i = 0; i < len; i++) {
            point = adjust(arr[i]);

            if (fsm[state][point] == -1)
                return false;

            state = fsm[state][point];
        }

        if (state == 0 || state == 2 || state == 4 || state == 7 || state == 9) return false;

        return true;
    }

    public int adjust(char c) {

        if (c >= '0' && c <= '9') return 1;

        if (c == '.') return 2;

        if (c == 'e' || c == 'E') return 3;

        if (c == '+' || c == '-') return 4;

        if (c == ' ') return 5;

        return 0;
    }
}