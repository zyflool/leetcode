package com.zyflool.kotlin

import java.util.*
import kotlin.math.max
import kotlin.math.min

/*
174. 地下城游戏
一些恶魔抓住了公主(P)并将她关在了地下城的右下角。地下城是由 MxN 个房间组成的二维网格。我们英勇的骑士(K)最初被安置在左上角的房间里，
他必须穿过地下城并通过对抗恶魔来拯救公主。
骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数(若房间里的值为负整数，则表示骑士将损失健康点数)；
其他房间要么是空的(房间里的值为 0)，要么包含增加骑士健康点数的魔法球(若房间里的值为正整数，则表示骑士将增加健康点数)。
为了尽快到达公主，骑士决定每次只向右或向下移动一步。

编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
-2(K)   -3    3
-5     -10    1
10      30   -5(P)

说明:
骑士的健康点数没有上限。;
任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */

fun main(args: Array<String>) {
    var dungeon: Array<IntArray> = Array(3) {IntArray(3) }
    dungeon[0][0] = -2
    dungeon[0][1] = -3
    dungeon[0][2] = 3
    dungeon[1][0] = -5
    dungeon[1][1] = -10
    dungeon[1][2] = 1
    dungeon[2][0] = 10
    dungeon[2][1] = 30
    dungeon[2][2] = -5
    println(calculateMinimumHP(dungeon))
}

/**
 * 考虑从右下往左上进行动态规划。
 * 令 dp[i][j] 表示从坐标 (i,j) 到终点所需的最小初始值。
 * 对于 dp[i][j]，我们只要关心 dp[i][j+1] 和 dp[i+1][j] 的最小值minn。
 * 记当前格子的值为 dungeon(i,j)，那么在坐标 (i,j) 的初始值只要达到 minn−dungeon(i,j) 即可。
 * 同时，初始值还必须大于等于 1。这样我们就可以得到状态转移方程：
 * dp[i][j] = max(min(dp[i+1][j], dp[i][j + 1]) - dungeon(i, j), 1)
 * 最终答案即为 dp[0][0]。
 *
 * 边界条件为，当 i=n-1 或者 j=m-1 时，
 * dp[i][j] 转移需要用到的 dp[i][j+1] 和 dp[i+1][j] 中有无效值，
 * 因此代码实现中给无效值赋值为极大值。
 * 特别地，dp[n−1][m−1] 转移需要用到的 dp[n-1][m] 和 dp[n][m−1] 均为无效值，
 * 因此我们给这两个值赋值为 1。
 */

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    val dp: Array<IntArray> = Array(dungeon.size+1){ IntArray(dungeon[0].size+1) }
    for (i in 0..dungeon.size)
        Arrays.fill(dp[i], Integer.MAX_VALUE);

    dp[dungeon.size][dungeon[0].size - 1] = 1
    dp[dungeon.size - 1][dungeon[0].size] = 1
    for ( i in dungeon.size-1 downTo 0 ) {
        for( j in dungeon[0].size-1 downTo 0 ) {
            val minn = min(dp[i + 1][j], dp[i][j + 1])
            dp[i][j] = max(minn - dungeon[i][j], 1)
        }
    }
    return dp[0][0]
}