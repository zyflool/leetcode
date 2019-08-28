import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
38. 报数
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。

示例 1:
输入: 1
输出: "1"

示例 2:
输入: 4
输出: "1211"
*/
class Solution {

    public static void main ( String[] args ) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        b.add(1);
        for ( int i = 2 ; i <= n ; i++ ) {
            if ( i % 2 == 0 ) {
                b.clear();
                int s = a.size();
                int tmp = a.get(0);
                int count = 1;
                for ( int j = 1 ; j < s ; j++ ) {
                    if ( tmp != a.get(j) ) {
                        b.add(count);
                        b.add(tmp);
                        tmp = a.get(j);
                        count = 1;
                    } else
                        count++;
                }
                b.add(count);
                b.add(tmp);
            } else {
                a.clear();
                int s = b.size();
                int tmp = b.get(0);
                int count = 1;
                for ( int j = 1 ; j < s ; j++ ) {
                    if ( tmp != b.get(j) ) {
                        a.add(count);
                        a.add(tmp);
                        tmp = b.get(j);
                        count = 1;
                    } else
                        count++;
                }
                a.add(count);
                a.add(tmp);
            }
        }
        StringBuilder string = new StringBuilder();
        if ( n % 2 == 0 ) {
            int s = b.size();
            for ( int i = 0 ; i < s ; i++ ) {
                string.append(""+b.get(i));
            }
        } else {
            int s = a.size();
            for ( int i = 0 ; i < s ; i++ ) {
                string.append(""+a.get(i));
            }
        }
        return string.toString();

    }
}
