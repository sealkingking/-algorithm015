package wu.seal.algorithms.leetcode

import java.util.*

/**
 * Created by Seal.Wu on 2020/9/3
 * Description: #144
 */
class TreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        root?:return emptyList()
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            result.add(pop.`val`)
            pop.right?.let { stack.push(it) }
            pop.left?.let { stack.push(it) }
        }
        return result
    }
}