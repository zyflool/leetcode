class Solution {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        if ( l == 1 )
            return nums[0];
        int Max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < l ; i++ ) {
            int tmp = nums[i];
            if ( Max < tmp )
                Max = tmp;
            for ( int j = 1 ; j < l - i ; j++ ) {
                tmp += nums[i+j];
                if ( Max < tmp )
                    Max = tmp;
            }
        }
        return Max;
    }
}