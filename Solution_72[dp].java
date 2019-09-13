/*
72. 编辑距离
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例 1:
输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2:
输入: word1 = "intention", word2 = "execution"
输出: 5
解释:
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
*/
class Solution {

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if ( l1 == 0 ) return l2;
        else if ( l2 == 0 ) return l1;
        int[][] dp = new int[l1+1][l2+1];
        for ( int i = 0 ; i <= l1 ; i++ )
            dp[i][0] = i;
        for ( int i = 0 ; i <= l2 ; i++ )
            dp[0][i] = i;
        for ( int i = 1 ; i <= l1 ; i++ ) {
            for ( int j = 1 ; j <= l2 ; j++ ) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]-1));
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[l1][l2];
    }
}