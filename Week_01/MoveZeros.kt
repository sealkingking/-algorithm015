package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/28
 * Description:
 */
class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        var a = 0
        var b = 0
        while (b < nums.size) {
            if (nums[b] != 0) {
                nums[a] = nums[b]
                if (b > a) {
                    nums[b] = 0
                }
                a++
            }
            b++
        }
    }
}