/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"
*/
class Solution {
    public static void main ( String[] args ) {
        String s = "ab";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        if ( n == 0 || n == 1 )
            return s;
        boolean[][] p = new boolean[n][n];
        for ( int i = 0 ; i < n ; i++ ) {
            p[i][i] = true;
            if ( i < n - 1 )
                p[i][i+1] = ( s.charAt(i) == s.charAt(i+1) );
        }

        boolean flag = true;
        int l = 4;
        while (flag == true) {
            flag = false;
            for (int i = 0; i + l - 1 < n; i++) {
                p[i][i+l-1] = ( p[i + 1][i + l - 1 - 1] && s.charAt(i) == s.charAt(i+l-1) );
                if (p[i][i+l-1] == true)
                    flag = true;
            }
            l+=2;
        }

        flag = true;
        l = 3;
        while (flag == true) {
            flag = false;
            for (int i = 0; i + l - 1 < n; i++) {
                p[i][i+l-1] = ( p[i + 1][i + l - 1 - 1] && s.charAt(i) == s.charAt(i+l-1) );
                if (p[i][i+l-1] == true)
                    flag = true;
            }
            l+=2;
        }

        int maxl = 0 ;
        String c = null;
        for ( int i = 0 ; i < n - 1; i++ ) {
            for ( int j = i ; j < n ; j++ ) {
                if ( j - i + 1 > maxl && p[i][j] ) {
                    if ( j + 1 != n )
                        c = s.substring(i, j + 1);
                    else
                        c = s.substring(i);
                    maxl = j - i + 1;
                }
            }
        }
        return c;
    }
}