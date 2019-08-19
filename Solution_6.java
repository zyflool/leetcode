import java.util.ArrayList;
import java.util.List;

/*
6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);

示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/
class Solution {
    public static void main ( String[] args ) {
        String s = "LEETCODEISHIRING";
        int n = 4;
        System.out.println(convert(s,n));
    }
    public static String convert(String s, int numRows) {
        if ( numRows == 1 )
            return s;
        StringBuffer[] res = new StringBuffer[numRows];
        for ( int j = 0 ; j < numRows ; j++ )
            res[j] = new StringBuffer();
        int l = s.length();
        int i = 0;
        int row = 0;
        boolean direction = false;//false向下 true向上
        while ( i != l ) {
            if ( i != l - 1 )
                res[row].append(s.substring(i,i+1));
            else
                res[row].append(s.substring(i));
            if ( row == 0 && direction == true )
                direction = false;
            else if ( row == numRows - 1 && direction == false )
                direction = true;
            if ( direction )
                row--;
            else row++;
            i++;
        }
        StringBuffer result = new StringBuffer();
        for ( int j = 0 ; j < numRows ; j++ )
            result.append(res[j].toString());
        return result.toString();
    }
}