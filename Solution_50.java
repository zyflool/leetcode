/*
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
*/
class Solution {

    public static void main(String[] args) {
        double x = 2.000000;
        int n = -2;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x, n));
    }

    private double myPowHelper(double x , long n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res *= x;
            }

            n = n >> 1;
            x *= x;
            //System.out.println(n);
        }

        return res;
    }

    public double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }else if (n > 0) {
            return myPowHelper(x,n);
        }else {
            return 1/myPowHelper(x,-n);
        }
    }
}