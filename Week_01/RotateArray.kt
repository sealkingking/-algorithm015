package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/29
 * Description: #189
 */
class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val rK = k % nums.size
        reverseArray(nums, 0, nums.size - 1)
        reverseArray(nums, 0, rK - 1)
        reverseArray(nums, rK, nums.size - 1)
    }

    private fun reverseArray(array: IntArray, from: Int, to: Int) {
        val reverseSize = to - from + 1
        for (i in 0 until reverseSize / 2) {
            val temp = array[i + from]
            array[i + from] = array[to - i]
            array[to - i] = temp
        }

    }

}