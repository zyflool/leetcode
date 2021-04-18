/*
231. 2的幂
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:
输入: 1
输出: true
解释: 2^0 = 1

示例 2:
输入: 16
输出: true
解释: 2^4 = 16

示例 3:
输入: 218
输出: false
*/
/*
若x是2的n次幂，则：
1、恒有 n & (n - 1) == 0，这是因为：
    n 二进制最高位为 1，其余所有位为 0；
    n−1 二进制最高位为 0，其余所有位为 1；
2、一定满足 n > 0
 */

public class Solution_231 {
    public static void main(String[] args) {
        Solution_231 solution = new Solution_231();
        System.out.println(solution.isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
//        if (n == 0)
//            return false;
//        while ((n & 1) != 1) {
//            n = n >> 1;
//        }
//        n = n & (~0 - 1);
//        return n == 0;
        return n > 0 && (n & (n - 1)) == 0;
    }

}
