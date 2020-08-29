package wu.seal.algorithms.leetcode

import java.lang.IllegalArgumentException

/**
 * Created by Seal.Wu on 2020/8/26
 * Description:
 */
class TowSum01 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = hashMapOf<Int,Int>()
        nums.forEachIndexed { index, i ->
            val complete = target - i
            if (hashMap.containsKey(complete)) {
                return intArrayOf(hashMap[complete]!!,index)
            }
            hashMap[i] = index
        }
        throw IllegalArgumentException("Cant find pair value equals target")
    }
}