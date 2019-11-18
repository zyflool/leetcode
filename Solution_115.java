/*
115. 不同的子序列
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

示例 1:
输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:
如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

示例 2:
输入: S = "babgbag", T = "bag"
输出: 5
解释:
如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
(上箭头符号 ^ 表示选取的字母)
babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/
class Solution {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Solution solution = new Solution();
        System.out.println(solution.numDistinct(s,t));
    }

    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if ( lt > ls ) return 0;
        if ( lt == ls ) {
            if( s.equals(t) )
                return 1;
            else return 0;
        }
        //f[i][j]  s的前i个字符中有多少个t的前j个字符
        //当第i位和第j位相同时，考虑第i位参不参与配对
        //当第i位和第j位不同时，第i位不会参与配对
        int[][] f = new int[ls+1][lt+1];
        for ( int i = 0 ; i <= ls ; i++ )
            f[i][0] = 1;
        for ( int i = 1 ; i <= ls ; i++ ) {
            for ( int j = 1 ; j <= lt ; j++ ) {
                f[i][j] = f[i-1][j];
                if ( s.charAt(i-1) == t.charAt(j-1) )
                    f[i][j] += f[i-1][j-1];
            }
        }
        return f[ls][lt];
    }
}
