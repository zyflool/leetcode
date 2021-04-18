/*
233. 数字 1 的个数
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

示例 1：
输入：n = 13
输出：6

示例 2：
输入：n = 0
输出：0

提示：
0 <= n <= 2 * 10^9
 */
/*
数学

可以发现：
0～9 1个
0～99 20个
0～999 300个
0～9999 4000个
0～9..9[n] n*10^(n-1)个

从最高位向低位计算，每次抛去低位的数字计算，根据最高位与1的关系判断额外多加多少次的1（大于1加上10^(位数-1)个，等于1加上低位组成的数+1），
如：1410065408
n(0 ～ 1000000000) + 410065409
n(0 ～ 400000000) + 100000000
n(0 ～ 10000000) + 65409
n(0 ～ 60000) + 10000
n(0 ～ 5000) + 1000
n(0 ～ 400) + 100
n(0 ～ 8)
累加和即为最终结果
*/
public class Solution_233 {

    public static void main(String[] args) {
        Solution_233 solution = new Solution_233();
        System.out.println(solution.countDigitOne(11));
    }

    public int countDigitOne(int n) {
        if (n < 10)
            return n >= 1 ? 1 : 0;
        int res = 0;
        while (n >= 10) {
            int count = 0;
            int m = n;
            int times = 0;
            while (m > 0) {
                count++;
                m /= 10;
                times = times == 0 ? 1 : times * 10;
            }
            count = ((count - 1) * (times / 10)) * (n / times);
            if (n / times > 1)
                count += times;
            else if (n / times == 1)
                count += n % times + 1;
            res += count;
            n = n % times;
        }
        res += n >= 1 ? 1 : 0;
        return res;
    }
}
