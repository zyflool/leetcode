/*
132. 分割回文串 II
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回符合要求的最少分割次数。

示例:
输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */

public class Solution {

    public static void main(String[] args) {
        String s = "aaba";
        Solution solution = new Solution();
        System.out.println(solution.minCut(s));
    }

    boolean[][] isPalindrome;

    public int minCut(String s) {
        if ( s == null || s.length() == 0 || s.length() == 1 )
            return 0;
        int l = s.length();
        isPalindrome = isPali(s);
        int[] dp = new int[l];
        for ( int i = 0 ; i < l ; i++ )
            dp[i] = i;
        for ( int i = 0 ; i < l ; i++ ) {
            for ( int j = i ; j < l ; j++ ) {
                if ( isPalindrome[i][j] ) {
                    if ( i == 0 )
                        dp[j] = 0;
                    else
                        dp[j] = Math.min(dp[i - 1] + 1, dp[j]);
                }
            }
        }
        return dp[l-1];
    }

    private boolean[][] isPali (String s) {
        int l = s.length();
        boolean[][] isPali = new boolean[l][l];
        for ( int i = 0 ; i < l ; i++)
            for ( int j = 0 ; j < l ; j++)
                isPali[i][j] = false;
        char[] chars = s.toCharArray();
        for ( int  mid = 0 ; mid < l ; mid++ ) {
            int i = mid;
            int j = mid;
            while ( i >= 0 && j < l && chars[i] == chars[j] ) {
                isPali[i][j] = true;
                i--;
                j++;
            }
            i = mid;
            j = mid+1;
            while ( i >= 0 && j < l && chars[i] == chars[j] ) {
                isPali[i][j] = true;
                i--;
                j++;
            }
        }
        return isPali;
    }
}