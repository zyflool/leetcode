package com.zyflool.kotlin
/*
169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
 */

fun main(args: Array<String>) {
    println(majorityElement(intArrayOf(1,2,1,2,1,2)))
}

/**方法一：
 * 摩尔投票法：
 * 候选人(candidate)初始化为nums[0]，票数count初始化为0。
 * 当遇到与candidate相同的数，则票数count++，否则票数count--。
 * 当票数count为0时，更换候选人，并将票数count重置为1。
 * 遍历完数组后，candidate即为最终答案。
 *
 * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
 * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
 * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
 * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
 */
fun majorityElement(nums: IntArray): Int {
    var count = 0
    var candidate = 0

    nums.forEach {
        if (count == 0) {
            candidate = it
            count++
        } else {
            if (it == candidate) {
                count++
            } else {
                count--
            }
        }
    }

    return candidate;
}
/*
方法二： 从小到大排序， 处于中间位的一定是众数
fun majorityElement(nums: IntArray) : Int {
    Arrays.sort(nums)
    return nums[nums.size shr 1]
}
*/