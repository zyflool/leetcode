/*
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int numRows = 5;
        Solution solution = new Solution();
        System.out.println(solution.generate(numRows));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        if ( numRows == 0 ) return answer;
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        answer.add(temp1);
        if ( numRows == 1 ) return answer;
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(1);    temp2.add(1);
        answer.add(temp2);
        if ( numRows == 2 ) return answer;
        for ( int i = 2 ; i < numRows ; i++ ) {
            List<Integer> pre = answer.get(i-1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for ( int j = 1 ; j < pre.size() ; j++ ) {
                int n = pre.get(j) + pre.get(j-1);
                temp.add(n);
            }
            temp.add(1);
            answer.add(temp);
        }
        return answer;
    }
}
