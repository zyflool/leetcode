import java.util.HashMap;
import java.util.Map;

/*
12. 整数转罗马数字
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
这个特殊的规则只适用于以下六种情况：
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:
输入: 3
输出: "III"

示例 2:
输入: 4
输出: "IV"

示例 3:
输入: 9
输出: "IX"

示例 4:
输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.

示例 5:
输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
*/
class Solution {
    public static void main ( String[] args ) {
        int n = 1437;
        System.out.println(intToRoman(n));
    }
    public static String intToRoman(int num) {
        if (num == 0) return "";
        if (num == 1) return "I";
        if (num == 2) return "II";
        if (num == 3) return "III";
        Map<Integer, Character> m = new HashMap<>();
        m.put(1,'I');
        m.put(5, 'V');
        m.put(10,'X');
        m.put(50, 'L');
        m.put(100,'C');
        m.put(500, 'D');
        m.put(1000,'M');
        int unit = 1000;
        StringBuffer result = new StringBuffer();
        while ( num > 0  && unit > 0) {
            if ( num / unit == 0)
                unit /= 10;
            else {
                int tmp = num / unit ;
                if ( tmp < 4 ) {
                    for ( int i = 1 ; i <= tmp ; i++ )
                        result.append( m.get( unit ) );
                } else if ( tmp == 4 ) {
                    result.append( m.get( unit ) );
                    result.append( m.get( unit * 5 ) );
                } else if ( tmp < 9 ) {
                    result.append( m.get( unit * 5 ) );
                    for (int i = 1; i <= tmp - 5 ; i++ )
                        result.append( m.get( unit ) );
                } else if ( tmp == 9 ) {
                    result.append( m.get( unit ) );
                    result.append( m.get( unit * 10 ) );
                }
                num %= unit;
                unit /= 10;
            }
        }
        return result.toString();
    }
}