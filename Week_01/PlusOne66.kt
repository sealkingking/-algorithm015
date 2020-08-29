package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/25
 * Description:
 */
class PlusOne66 {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.indices.reversed()) {
            digits[i]++
            if (digits[i] % 10 != 0) {//说明没有进位,此时可以结束循环返回了
                return digits
            }
        }
        //到这里的情况是类似9999999这种数字,加1后变成100000000
        return IntArray(digits.size + 1) { 0 }.apply { this[0] = 1 }
    }
}