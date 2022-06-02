/**
 * 面试题 16.07. 最大数值
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximum(-1,-3);
    }

    public int maximum(int a, int b) {
        /*
         *  sign = (x >> 31) + 1
         *  sign = 1  =>  正数
         *  sign = 0  =>  负数
         */
        int signA = (a >> 31) + 1;
        int signB = (b >> 31) + 1;

        /*
         * a or b  = 1 or 0
         * diff = ( a & b ) & ( ~a & ~b )
         * diff = 1  =>  不同
         * diff = 0  =>  相同
         */
        int signDiff = (signA | signB) & ((~signA) | (~signB));

        return signDiff * (signA * a + (1 - signA) * b) +
                (1 - signDiff) * (
                        (((a - b) >> 31) + 1) * a +
                                (1 - (((a - b) >> 31) + 1)) * b
                );
    }
}
