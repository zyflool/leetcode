/*
57. 插入区间
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:
输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]

示例 2:
输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
*/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,5},{8,9}};
        int[] newInterval = new int[]{3,4};
        Solution solution = new Solution();
        int[][] answer = solution.insert(intervals,newInterval);
        int n = answer.length;
        for (int i = 0; i < n; i++)
            System.out.println(answer[i][0] + " " + answer[i][1]);
    }

        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            if ( intervals.length == 0 && newInterval.length != 0) {
                int[][] temp = new int[1][2];
                temp[0] = newInterval;
                return temp;
            } else if ( intervals.length != 0 && newInterval.length == 0) {
                return intervals;
            } else if ( intervals.length == 0 && newInterval.length == 0 ) {
                return null;
            } else {
                int n = intervals.length;
                boolean isInserted = false;
                for ( int i = 0 ; i < n ; i++ ) {
                    if ( isInserted ) {
                        ans.add(intervals[i]);
                    } else {
                        if ( i == 0 && newInterval[0] <= intervals[i][0] ) {  //如果比最小更小
                            int j = i;
                            while (j < n && newInterval[1] >= intervals[j][1]) {//找到后面第一个没有被新的区间完全覆盖的区间
                                j++;
                            }
                            if (j == n ) { //如果新区间的右值比左值最大的区间右值更大，覆盖所有区间退出循环
                                ans.add(newInterval);
                                isInserted = true;
                                break;
                            } else {
                                if (newInterval[1] >= intervals[j][0]) { //如果没有被完全覆盖的区间被覆盖了一部分
                                    int[] temp = new int[2];
                                    temp[0] = newInterval[0];
                                    temp[1] = intervals[j][1];
                                    ans.add(temp);
                                    i = j;
                                    isInserted = true;
                                    continue;
                                } else if (newInterval[1] < intervals[j][0]) { //如果没有被完全覆盖的区间完全没有被新区间覆盖
                                    ans.add(newInterval);
                                    ans.add(intervals[j]);
                                    i = j;
                                    isInserted = true;
                                    continue;
                                }
                            }
                        } else if (i != n - 1 && newInterval[0] < intervals[i+1][0] && newInterval[0] >= intervals[i][0]) { //在中间
                            int[] temp = new int[2];
                            //先考虑起始点
                            if ( intervals[i][1] >= newInterval[0] ) //如果新区间覆盖了一部分interval[i],起始点为intervals[i][0]
                                temp[0] = intervals[i][0];
                            else  { //新区间与intervals[i]完全没有交集 ： 直接添加;起始点为newInterval[0]
                                ans.add(intervals[i]);
                                temp[0] = newInterval[0];
                            }

                            //考虑终点
                            if ( intervals[i+1][0] > newInterval[1] ) { //如果新区间完全与intervals[i+1]没有交集,终点为newInterval[1]
                                temp[1] = Math.max(newInterval[1], intervals[i][1]);
                                ans.add(temp);
                                isInserted = true;
                            } else {//新区间与后面的区间有交集，需要合并
                                int j = i;
                                while ( j < n && intervals[j][1] <= newInterval[1] ) //找到第一个没有被新区间完全覆盖的区间
                                    j++;
                                if ( j == n ) { //如果新区间的右值比左值最大的区间右值更大，覆盖所有区间退出循环
                                    temp[1] = newInterval[1];
                                    ans.add(temp);
                                    isInserted = true;
                                    break;
                                } else if (newInterval[1] >= intervals[j][0]) { //如果没有被完全覆盖的区间被覆盖了一部分
                                    temp[1] = intervals[j][1];
                                    ans.add(temp);
                                    i = j;
                                    isInserted = true;
                                    continue;
                                } else if (newInterval[1] < intervals[j][0]) { //如果没有被完全覆盖的区间完全没有被新区间覆盖
                                    temp[1] = newInterval[1];
                                    ans.add(temp);
                                    ans.add(intervals[j]);
                                    i = j;
                                    isInserted = true;
                                    continue;
                                }
                            }

                        } else if ( i == n - 1 && newInterval[0] >= intervals[i][0] ) { //如果 新区间的右值 比 左值最大的区间的右值 更大
                            if ( intervals[i][1] < newInterval[0] ) { //如果新区间完全没有覆盖最后一个区间
                                ans.add(intervals[i]);
                                ans.add(newInterval);
                            } else { //如果新区间覆盖了一部分最后的区间 找极值
                                int[] temp = new int[2];
                                temp[0] = Math.min(newInterval[0], intervals[i][0]);
                                temp[1] = Math.max(newInterval[1],intervals[i][1]);
                                ans.add(temp);
                            }
                        } else{ //没有遇到可插入的地方，继续添加原有的区间
                            ans.add(intervals[i]);
                        }
                    }
                }
            }
            int m = ans.size();
            int[][] answer = new int[m][2];
            for ( int i = 0 ; i < m ; i++ )
                answer[i] = ans.get(i);
            return answer;
        }
}