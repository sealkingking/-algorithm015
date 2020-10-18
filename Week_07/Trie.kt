package wu.seal.algorithms.leetcode

/**
 * Created by Seal.Wu on 2020/10/18
 * Description: #208
 */
class Trie {

    /** Initialize your data structure here. */

    val nodes = Array<Trie?>(26) { null }
    var isEnd = false //表示是否是一个单词的结尾

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var currentNode: Trie = this
        for (c in word) {
            currentNode.nodes[c - 'a'] = currentNode.nodes[c - 'a'] ?: Trie()
            currentNode = currentNode.nodes[c - 'a']!!
        }
        currentNode.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var currentNode: Trie = this
        for (c in word) {
            if (currentNode.nodes[c - 'a'] == null) return false
            currentNode = currentNode.nodes[c - 'a']!!
        }
        return currentNode.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var currentNode: Trie = this
        for (c in prefix) {
            if (currentNode.nodes[c - 'a'] == null) return false
            currentNode = currentNode.nodes[c - 'a']!!
        }
        return true

    }

}
