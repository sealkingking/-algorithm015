package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/29
 * Description: #26
 */
class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var a = 1
        var b = 1
        var newArrayCount = 1
        var preValue = nums[0]
        while (b < nums.size) {
            if (nums[b] == preValue) {
                b++
            } else {
                nums[a] = nums[b++]
                preValue = nums[a++]
                newArrayCount++
            }
        }
        return newArrayCount
    }
}