/*
66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        digits[l-1] += 1;
        if ( l == 1 && digits[0] == 10 ) {
            int[] tmp = { 1 , 0 };
            return tmp;
        } else if ( l == 1 )
            return digits;
        for ( int i = l - 1 ; i >= 0 ; i-- ) {
            if ( digits[i] >= 10 ) {
                digits[i] -= 10;
                if ( i != 0)
                    digits[i-1]++;
                else {
                    int[] tmp = new int[l+1];
                    tmp[0] = 1;
                    for (int j = 1 ; j < l + 1 ; j++ )
                        tmp[j] = digits[j-1];
                    return tmp;
                }
            }
        }
        return digits;
    }
}
