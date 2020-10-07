package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/10/7
 * Description: #91
 */
class NumDecodings {
    /**
     * 动态规划:
     * a.分治子问题:
     * count(n) = if(1==v(n) && v(n-1)!=0||(v(n)==2 && 1<=v(n-1)<=6) && v(n-2)!=0) count(n-2) + count(n-1)
     * else if (v(n-1)==0) count(n-2)
     * else count(n-1)
     * b.状态数组: dp[n]
     * c.动态方程:
     * f(n) = if(1==v(n) && v(n-1) !=0 ||(v(n)==2 &&1<=v(n-1)<=6) && v(n-2)!=0) f(n-1)+f(n-2)
     * else if (v(n-1)==0) f(n-2)
     * else f(n-1)
     * f(0) = 1
     */
    fun numDecodings(s: String): Int {
        if (s.startsWith('0')) return 0
        val rs = s.reversed()
        if (rs.isEmpty()) return 0
        if (rs.length == 1) return 1
        val dp = IntArray(rs.length)
        dp[0] = 1
        dp[1] = if (rs[0] != '0' && (rs[1] == '1' || rs[1] == '2' && rs[0] in '1'..'6')) 2 else 1
        if (rs[1] > '2' && rs[0] == '0') dp[1] = 0
        for (i in 2 until rs.length) {
            if (rs[i - 1] == rs[i - 2] && rs[i - 1] == '0') return 0
            if (rs[i - 1] == '0' && rs[i] > '2') return 0
            dp[i] = if (rs[i - 1] != '0'
                    && (rs[i] == '1' || rs[i] == '2' && rs[i - 1] in '1'..'6')
                    && rs[i - 2] != '0') {
                dp[i - 1] + dp[i - 2]
            } else if (rs[i - 1] == '0') dp[i - 2]
            else dp[i - 1]
        }
        return dp.last()
    }
}