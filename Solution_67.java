/*
67. 二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
*/
class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int l = la;
        if ( l < lb )
            l = lb;
        int[] num = new int[l+1];
        int count = l;
        num[count] = 0;
        for ( int i = la - 1 , j = lb - 1 ; i>=0||j>=0 ; i-- , j-- ) {
            if ( i < 0 )
                num[count] += (int)(b.charAt(j)-'0');
            else if ( j < 0 )
                num[count] += (int)(a.charAt(i)-'0');
            else
                num[count] += (int)(a.charAt(i)-'0') + (int)(b.charAt(j)-'0');
            if ( num[count] < 2 ) {
                count--;
                num[count] = 0;
            } else {
                num[count] -= 2;
                count--;
                num[count] = 1;
            }
        }
        StringBuilder res = new StringBuilder();
        if ( num[0] != 0 )
            res.append(""+num[0]);
        for ( int i = 1 ; i <= l ; i++ ) {
            res.append(""+num[i]);
        }
        return res.toString();
    }
}
