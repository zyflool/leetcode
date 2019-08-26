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
我们定义一个 dp[i] 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。我们将 dp[i] 数组全部初始化为 0。
现在，很明显有效的子字符串一定以 ‘)’ 结尾。这进一步可以得出结论：以 ‘(’ 结尾的子字符串对应的 dp[i] 数组位置上的值必定为 0 。
所以说我们只需要更新 ‘)’ 在 dp[i] 数组中对应位置的值。

为了求出 dp[i] 数组，我们每两个字符检查一次，如果满足如下条件
1、s[i] == ‘)’ 且 s[i−1] == ‘(’ ，也就是字符串形如"……()"，我们可以推出：dp[i]=dp[i−2]+2
我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。

2、s[i] = ‘)’ 且 s[i−1] = ‘)’，也就是字符串形如 ".......))" ，我们可以推出：
如果 s[ i − dp[i−1] − 1 ] = ‘(’ ，那么  dp[i] = dp[i − 1] + dp[ i − dp[ i − 1] − 2 ] + 2
这背后的原因是如果倒数第二个 ‘)’ 是一个有效子字符串的一部分(记为 sub_s)，对于最后一个 ‘)’ ，
如果它是一个更长子字符串的一部分，那么它一定有一个对应的 ‘(’ ，它的位置在倒数第二个 ‘)’ 所在的有效子字符串的前面(也就是 sub_s的前面)。
因此，如果子字符串 sub_s的前面恰好是 ‘(’ ，那么我们就用 2 加上 sub_s的长度（dp[i−1]）去更新 dp[i]。
除此以外，我们也会把有效子字符串 "(,sub_s,)"之前的有效子字符串的长度也加上，也就是加上 dp[i−dp[i−1]−2] 。
*/
import java.util.Stack;

class Solution {

    public static void main ( String[] args ) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}