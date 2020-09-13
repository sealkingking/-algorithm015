package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/13
 * Description: #77
 */
class Combine {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        helper((1..n).toList(), k, 0, mutableListOf<Int>(), result)
        return result
    }

    private fun helper(
        available: List<Int>,
        k: Int,
        min: Int,
        param: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (k == 0) {
            result.add(param)
            return
        }
        available.filter { it > min }.forEach { element ->
            helper(
                available.toMutableList().apply { remove(element) },
                k - 1,element,
                param.toMutableList().apply { add(element) },
                result
            )
        }
    }
}