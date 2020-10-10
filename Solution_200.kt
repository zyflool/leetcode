package com.zyflool.kotlin

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1:
输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1

示例 2:
输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */


fun main(args: Array<String>) {
    val grid = Array(4){ CharArray(5) }
    grid[0] = "11000".toCharArray()
    grid[1] = "11000".toCharArray()
    grid[2] = "00100".toCharArray()
    grid[3] = "00011".toCharArray()
    println(numIslands(grid))
}

fun numIslands(grid: Array<CharArray>): Int {
    if(grid.isEmpty())
        return 0

    var step = 0;
    val row = grid.size
    val colum = grid[0].size
    for(i in 0 until row){
        for(j in 0 until colum){
            if(grid[i][j] == '1'){
                step++
                dfs(i,j,row,colum,grid)
            }
        }
    }
    return step
}

fun dfs(x1:Int,y1:Int,row:Int,colum:Int,grid:Array<CharArray>){
    if(x1<0 || x1>=row || y1<0 || y1>=colum || grid[x1][y1] == '0')
        return

    grid[x1][y1] = '0'
    dfs(x1+1,y1,row,colum,grid)
    dfs(x1-1,y1,row,colum,grid)
    dfs(x1,y1+1,row,colum,grid)
    dfs(x1,y1-1,row,colum,grid)
}

