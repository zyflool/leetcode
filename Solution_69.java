/*
69. x 的平方根
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
由于返回类型是整数，小数部分将被舍去。
*/
class Solution {
    public int find(int x,long mid){
        if(mid*mid==x) return 1;
        if(mid*mid<x&&(mid+1)*(mid+1)>x) return 1;
        if((mid+1)*(mid+1)<=x) return 2;
        return -1;
    }

    public int mySqrt(int x) {
        /*
        用的二分法，最大整数开方不超过46340
        该问题就转化为在1--46340中找到一个数字n，n为x的开方
        */
        if(x==0) return 0;
        long begin=1,end=46341,mid=(begin+end)/2;
        while(begin<end){
            int temp=find(x,mid);
            if(temp==1) return (int)mid;
            if(temp==2){
                begin=mid+1;
                mid=(begin+end)/2;
            }
            else{
                end=mid-1;
                mid=(begin+end)/2;
            }
        }
        return (int)mid;
    }
}
