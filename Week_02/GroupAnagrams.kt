package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/3
 * Description: #49
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val array = IntArray(26)
        val hashMap = hashMapOf<String,MutableList<String>>()
        strs.forEachIndexed { index, s ->
            array.fill(0)
            s.forEach { array[it - 'a']++ }
            val key = array.joinToString("#")
            if (hashMap[key] == null) {
                hashMap[key] = mutableListOf(s)
            } else {
                hashMap[key]!!.add(s)
            }
        }
        return hashMap.values.toList()
    }
}