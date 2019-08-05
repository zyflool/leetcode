/*
 
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int from = 0;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            for ( int j = from ; j < i ; j++ ) {
                if ( s.charAt(j) == c )
                    from = j + 1;
            }
            max =  i + 1 - from > max  ?  i + 1 - from  :  max;
        }
        return max;
    }
}
