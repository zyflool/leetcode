/*
58. 最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:
输入: "Hello World"
输出: 5
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        if ( l == 0 )
            return l;
        while ( s.charAt(l-1) == ' ' ) {
            l--;
            if ( l == 0 )
                return l;
        }
        int last = s.lastIndexOf(' ' , l-1);
        if (last < 0)
            return l;
        else
            return l-last-1;
    }
}
