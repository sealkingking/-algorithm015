package wu.seal.algorithms.leetcode

import java.util.*

/**
 * #105
 */
class BuildTreePreorderAndInorder {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val hashMap = hashMapOf<Int, Int>()
        inorder.forEachIndexed { index, i -> hashMap[i] = index }
        val pLeft = 0
        val pRight = preorder.size - 1
        val iLeft = 0
        val iRight = inorder.size - 1
        return buildTree(preorder, pLeft, pRight, inorder, iLeft, iRight, hashMap)
    }

    private fun buildTree(
        preorder: IntArray,
        pLeft: Int,
        pRight: Int,
        inorder: IntArray,
        iLeft: Int,
        iRight: Int,
        hashMap: HashMap<Int, Int>
    ): TreeNode? {
        if (pLeft > pRight || iLeft > iRight){
            return null
        }
        val nodeValue = preorder[pLeft]
        val nodeIndex = hashMap[nodeValue]!!
        val leftSubTreeSize = nodeIndex - iLeft
        val rightSubTreeSize = iRight - nodeIndex

        val pSubTreeLeft1 = pLeft + 1
        val pSubTreeRight1 = pSubTreeLeft1 - 1 + leftSubTreeSize
        val pSubTreeLeft2 = pSubTreeRight1 + 1
        val pSubTreeRight2 = pSubTreeLeft2 + rightSubTreeSize

        val iSubTreeLeft1 = iLeft
        val iSubTreeRight1 = iLeft + leftSubTreeSize - 1
        val iSubTreeLeft2 = nodeIndex + 1
        val iSubTreeRight2 = iSubTreeLeft2 + rightSubTreeSize - 1

        val leftNode =
            buildTree(preorder, pSubTreeLeft1, pSubTreeRight1, inorder, iSubTreeLeft1, iSubTreeRight1, hashMap)
        val rightNode =
            buildTree(preorder, pSubTreeLeft2, pSubTreeRight2, inorder, iSubTreeLeft2, iSubTreeRight2, hashMap)
        return TreeNode(nodeValue).apply { left = leftNode;right = rightNode }
    }
}