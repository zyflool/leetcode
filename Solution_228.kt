package com.zyflool.kotlin

/*
228. 汇总区间
给定一个无重复元素的有序整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b

示例 1：
输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

示例 2：
输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

示例 3：
输入：nums = []
输出：[]

示例 4：
输入：nums = [-1]
输出：["-1"]

示例 5：
输入：nums = [0]
输出：["0"]

提示：
0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
nums 中的所有值都 互不相同
 */

fun main() {
    println(summaryRanges(intArrayOf(-1)).joinToString())
}

fun summaryRanges(nums: IntArray): List<String> {
    if ( nums.isEmpty() )
        return MutableList(0){""}
    if ( nums.size == 1 )
        return List(1){nums[0].toString()}
    val ans = MutableList(0){""}
    var start = nums[0]
    var end = nums[0]
    for ( i in 1 until nums.size) {
        end = if ( nums[i] == end + 1 )
            nums[i]
        else {
            if ( start != end )
                ans.add("$start->$end")
            else ans.add("$start")
            start = nums[i]
            nums[i]
        }
    }
    if ( start != end )
        ans.add("$start->$end")
    else ans.add("$start")
    return ans.toList()
}