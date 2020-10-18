package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/25
 * Description: #70
 */
class ClimbStairs {
    fun climbStairs(n: Int): Int {
        var a = 0
        var b = 0
        var c = 1
        repeat(n) {
            a = b
            b = c
            c = a + b
        }
        return c
    }
}