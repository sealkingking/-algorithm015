package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/8/29
 * Description:
 */
class MergeTwoLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var mergedListTail: ListNode = dummy
        var l1CurrentNode = l1
        var l2CurrentNode = l2
        while (l1CurrentNode != null && l2CurrentNode != null) {
            if (l1CurrentNode.`val` > l2CurrentNode.`val`) {
                mergedListTail.next = l2CurrentNode
                mergedListTail = l2CurrentNode
                l2CurrentNode = l2CurrentNode.next
            } else {
                mergedListTail.next = l1CurrentNode
                mergedListTail = l1CurrentNode
                l1CurrentNode = l1CurrentNode.next
            }
        }
        mergedListTail.next = l1CurrentNode ?: l2CurrentNode
        return dummy.next
    }
}