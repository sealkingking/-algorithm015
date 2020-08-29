package wu.seal.algorithms.leetcode

import java.util.*

/**
 * Created by Seal.Wu on 2020/8/29
 * Description:
 */
class Trap {
    fun trap(height: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>()
        var total = 0
        height.forEachIndexed { index, it ->
            if (stack.empty().not()) {
                if (it > stack.peek().first) {
                    println("start calc when it's value is $it in index $index")
                    while (!stack.empty() && stack.peek().first < it) {
                        val p = stack.pop()
                        if (stack.empty()) {
                            break
                        }
                        val pre = stack.peek()
                        val h = Math.min(it, pre.first) - p.first
                        val added = h * (index - pre.second - 1)
                        println("added area is $added")
                        total += added

                    }
                }
            }
            stack.push(Pair(it, index))
        }

        return total
    }
}