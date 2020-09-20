package wu.seal.algorithms.leetcode

/**
 *  Created by Seal.Wu(wuhaibao) on 2020/9/18
 *  Description: #860
 */
class LemonadeChange {
    fun lemonadeChange(bills: IntArray): Boolean {
        val hashMap = hashMapOf(5 to 0, 10 to 0, 20 to 0)
        bills.forEach {
            hashMap[it] = hashMap[it]!! + 1
            var toBeGive = it - 5
            if (toBeGive == 0) return@forEach
            while (toBeGive >= 20 && hashMap[20]!! > 0) {
                toBeGive -= 20
                hashMap[20] = hashMap[20]!! - 1
            }

            while (toBeGive >= 10 && hashMap[10]!! > 0) {
                toBeGive -= 10
                hashMap[10] = hashMap[10]!! - 1
            }

            while (toBeGive >= 5 && hashMap[5]!! > 0) {
                toBeGive -= 5
                hashMap[5] = hashMap[5]!! - 1
            }
            if (toBeGive > 0) return false
        }
        return true
    }
}