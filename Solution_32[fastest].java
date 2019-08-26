/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
*/

/*
我们利用两个计数器 left 和 right 。
首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，我们增加 left 计算器，对于遇到的每个 ‘)’ ，我们增加 right 计数器。
每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
如果 right 计数器比 left 计数器大时，我们将 left 和 right 计数器同时变回 0 。

接下来，我们从右到左做一遍类似的工作。
每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
如果 left 计数器比 right 计数器大时，我们将 left 和 right 计数器同时变回 0。
 */
class Solution {

    public static void main ( String[] args ) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}