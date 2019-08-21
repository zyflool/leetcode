/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。
*/
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main ( String[] args ) {
        String[] s = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strs));
        int n = list.size();
        if (n == 0)
            return "";
        if (n == 1)
            return list.get(0);
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (len >= list.get(i).length())
                len = list.get(i).length();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < len; j++) {
                if (list.get(i).charAt(j) != list.get(i + 1).charAt(j)) {
                    len = j;
                    break;
                }
            }
        }
        String res = list.get(0).substring(0, len);
        return res;
    }
}