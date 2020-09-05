package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/9/3
 * Description:#420
 */
class TreeLevelOrder {
    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val result = mutableListOf<List<Int>>()
        levelNodes(result, listOf(root))
        return result
    }

    private fun levelNodes(result: MutableList<List<Int>>, currentLevelNodes: List<Node?>) {
        if (currentLevelNodes.isEmpty()) {
            return
        }
        val currentLevelIntValues = currentLevelNodes.mapNotNull { it?.`val` }
        result.add(currentLevelIntValues)
        val nextLevelNodes = currentLevelNodes.filterNotNull().flatMap { it.children.asIterable() }
        levelNodes(result, nextLevelNodes)
    }
}