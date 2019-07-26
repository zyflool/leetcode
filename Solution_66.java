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