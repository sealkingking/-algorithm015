package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/2
 * Description: #242
 */
class IsAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val array = IntArray(26)
        s.forEach { array[it - 'a']++ }
        t.forEach { array[it - 'a']-- }
        return array.all { it==0 }
    }
}