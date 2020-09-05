package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/26
 * Description: #1
 */
class TowSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (hashMap[target - i] != null) {
                return intArrayOf(hashMap[target - i]!!, index)
            }
            hashMap[i] = index
        }
        return intArrayOf()
    }
}