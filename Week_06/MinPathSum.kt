package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/10/4
 * Description: #64
 */
class MinPathSum {

    /**
     * 暴力: 2^n
     * 动态规划:
     * a. 分治子问题: path_sum(x,y) = min(path_sum(x-1,y),path_sum(x,y-1))
     * b. 状态数组: dp[y][x]
     * c. 动态方程: f(x,y) = min(f(x-1,y),f(x,y-1)) + v(x,y)
     *            f(x(x<0),y) = f(0,y)
     *            f(x,y(y<0)) = f(x,0)
     *            dp[0][0] = v(0,0)
     */
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid.first().size) }
        grid.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, v ->
                if (x > 0 && y > 0) {
                    dp[y][x] = dp[y - 1][x].coerceAtMost(dp[y][x - 1]) + v
                } else if (x == 0 && y > 0) {
                    dp[y][x] = dp[y - 1][x] + v
                } else if (y == 0 && x > 0) {
                    dp[y][x] = dp[y][x - 1] + v
                } else {
                    dp[y][x] = grid[y][x]
                }
            }
        }
        return dp.last().last()
    }
}