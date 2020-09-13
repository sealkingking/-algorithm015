package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/10
 * Description: #236
 */
class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == p || root == q || root == null) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        return when {
            left == null -> {
                right
            }
            right == null -> {
                left
            }
            else -> {
                root
            }
        }
    }
}