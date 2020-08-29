package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/29
 * Description: #88
 */
class MergeTwoArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var a = m - 1
        var b = n - 1
        var end = m + n - 1
        while (a >= 0 || b >= 0) {
            if (b < 0 || (a > 0 && nums1[a] > nums2[b])) {
                nums1[end--] = nums1[a--]
            } else {
                nums1[end--] = nums2[b--]
            }
        }
    }
}