package wu.seal.algorithms.leetcode

import java.util.*

/**
 * Created by Seal.Wu on 2020/9/2
 * Description: #589
 */
class TreePreorder {

    fun preorder(root: Node?): IntArray {
        if (root == null) {
            return intArrayOf()
        }
        val stack = Stack<Node>()
        val result = mutableListOf<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            result.add(pop.`val`)
            pop.children.filterNotNull().reversed().forEach { stack.push(it) }
        }
        return result.toIntArray()
    }

}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}