package wu.seal.algorithms.leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 *  Created by Seal.Wu(wuhaibao) on 2020/9/17
 *  Description: #127
 */
class LadderLength {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toHashSet()
        val queue = LinkedList<String>()
        val visited = hashSetOf<String>()
        queue.offer(beginWord)
        visited.add(beginWord)
        var step = 1
        while (queue.isNotEmpty()) {
            step++
            repeat(queue.size) {
                if (changeOneLetterToNextLevel(queue, visited, wordSet, queue.poll(), endWord)) return step
            }
        }
        return 0
    }

    private fun changeOneLetterToNextLevel(queue: LinkedList<String>, visited: HashSet<String>, wordSet: HashSet<String>, current: String, endWord: String): Boolean {
        val cs = current.toCharArray()
        for (index in cs.indices) {
            val origin = cs[index]
            for (c in 'a'..'z') {
                if (c == origin) continue
                cs[index] = c
                val nS = cs.joinToString("")
                if (wordSet.contains(nS) && visited.contains(nS).not()) {
                    if (nS == endWord) return true
                    visited.add(nS)
                    queue.offer(nS)
                }
            }
            cs[index] = origin
        }
        return false
    }
}