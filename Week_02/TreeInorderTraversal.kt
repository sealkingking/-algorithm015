package wu.seal.algorithms.leetcode

import java.util.*

/**
 * Created by Seal.Wu on 2020/9/3
 * Description: #94
 */
class TreeInorderTraversal {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?:return emptyList()
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root
        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop()
            result.add(cur.`val`)
            cur = cur.right
        }
        return result
    }
}