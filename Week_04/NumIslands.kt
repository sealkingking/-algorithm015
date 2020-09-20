package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/19
 * Description: #200
 */
class NumIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var num = 0
        grid.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (grid[i][j] == '1') {
                    num++
                    markIslandToWater(grid, i, j)
                }
            }
        }
        return num
    }

    private fun markIslandToWater(grid: Array<CharArray>, i: Int, j: Int) {
        grid[i][j] = '0'
        val xt = (i - 1).coerceAtLeast(0)
        val xb = (i + 1).coerceAtMost(grid.size - 1)
        val yl = (j - 1).coerceAtLeast(0)
        val yr = (j + 1).coerceAtMost(grid[0].size - 1)
        if (grid[xt][j] == '1') {
            markIslandToWater(grid, xt, j)
        }
        if (grid[xb][j] == '1') {
            markIslandToWater(grid, xb, j)
        }
        if (grid[i][yl] == '1') {
            markIslandToWater(grid, i, yl)
        }
        if (grid[i][yr] == '1') {
            markIslandToWater(grid, i, yr)
        }
    }
}