/*
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"

说明：
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/
class Solution {


    public static void main(String[] args) {
        String num1 = "3";
        String num2 = "2";
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if ( num1.equals("0") || num2.equals("0") )
            return "0";
        if ( num1.equals("1") )
            return num2;
        if ( num2.equals("1") )
            return num1;
        if ( num2.length() > num1.length() ) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int l = num2.length();
        StringBuffer res = new StringBuffer();
        int i = l - 1;
        while ( i >= 0 ) {
            StringBuffer t = new StringBuffer();
            if ( i != l - 1 ) {
                for ( int p = l - 1 ; p > i ; p-- )
                    t.append('0');
            }
            int s = num2.charAt(i) - '0';
            int last = 0;
            for ( int j = num1.length() - 1 ; j >= 0 ; j-- ) {
                int k = num1.charAt(j) - '0';
                int product = s * k + last;
                t.append((char) ((product % 10)+'0'));
                last = product / 10;
            }
            if ( last != 0 )
                t.append((char)(last+'0'));
            if ( i == l - 1 ) {
                res = t;
            } else {
                int resl = res.length();
                int tl = t.length();
                if ( resl > tl ) {
                    int j = 0;
                    int pre = 0;
                    while ( j < tl ) {
                        int a = res.charAt(j) - '0';
                        int b = t.charAt(j) - '0';
                        int sum = a + b + pre;
                        StringBuffer temp = new StringBuffer();
                        temp.append((char)((sum%10)+'0'));
                        res.replace(j,j+1,temp.toString());
                        pre = sum / 10;
                        j++;
                    }
                    while ( j < resl && pre != 0 ) {
                        int a = res.charAt(j) - '0';
                        int sum = a + pre;
                        StringBuffer temp = new StringBuffer();
                        temp.append((char)((sum%10)+'0'));
                        res.replace(j,j+1,temp.toString());
                        pre = sum / 10;
                        j++;
                    }
                    if ( pre != 0 )
                        res.append((char)(pre+'0'));
                } else {
                    int j = 0;
                    int pre = 0;
                    while ( j < resl ) {
                        int a = res.charAt(j) - '0';
                        int b = t.charAt(j) - '0';
                        int sum = a + b + pre;
                        StringBuffer temp = new StringBuffer();
                        temp.append((char)((sum%10)+'0'));
                        res.replace(j,j+1,temp.toString());
                        pre = sum / 10;
                        //System.out.println(a+" + "+b + " + " + pre+" = " + sum+"  --->  "+res.toString());
                        j++;
                    }
                    while ( j < tl ) {
                        int a = t.charAt(j) - '0';
                        int sum = a + pre;
                        res.append((char)((sum%10)+'0'));
                        pre = sum / 10;
                        j++;
                    }
                    if ( pre != 0 )
                        res.append((char)(pre+'0'));
                }
                //System.out.println(res.toString());
            }
            i--;
        }
        return res.reverse().toString();
    }
}