package wu.seal.algorithms.leetcode

import java.util.*

/**
 * Created by Seal.Wu on 2020/8/29
 * Description: #641
 */
class MyCircularDeque(k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */

    private val stackFront = Stack<Int>()
    private val stackEnd = Stack<Int>()
    private val maxSize = k
    private var currentSize = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (currentSize + 1 > maxSize) {
            return false
        }
        currentSize++
        stackFront.push(value)
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (currentSize + 1 > maxSize) {
            return false
        }
        currentSize++
        stackEnd.push(value)
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (currentSize < 1) {
            return false
        }
        currentSize--
        if (stackFront.empty()) {
            stackEnd.popTo(stackFront)
        }
        stackFront.pop()
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (currentSize < 1) {
            return false
        }
        currentSize--
        if (stackEnd.empty()) {
            stackFront.popTo(stackEnd)
        }
        stackEnd.pop()
        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (currentSize > 0) {
            if (stackFront.empty()) {
                stackEnd.popTo(stackFront)
            }
            return  stackFront.peek()
        }
        return -1
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (currentSize > 0) {
            if (stackEnd.empty()) {
                stackFront.popTo(stackEnd)
            }
            return stackEnd.peek()
        }
        return -1
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return currentSize == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return currentSize == maxSize
    }

    private fun <E> Stack<E>.popTo(dest: Stack<E>) {
        while (empty().not()) {
            dest.push(pop())
        }
    }

}
