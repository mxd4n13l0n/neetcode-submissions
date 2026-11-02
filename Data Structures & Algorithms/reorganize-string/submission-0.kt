class Solution {
    fun reorganizeString(s: String): String {
        val freq = mutableMapOf<Char, Int>()
        s.forEach { char ->
            freq[char] = freq.getOrDefault(char, 0) + 1
        }

        val heap = PriorityQueue<LetterCounts>() { a, b ->
            b.amount - a.amount
        }
        freq.forEach { key, value ->
            heap.add(LetterCounts(key, value))
        }

        var result = StringBuilder()

        var curr: LetterCounts? = null
        while (heap.size > 0) {
            val next = heap.poll()
            result.append(next.char)
            next.amount -= 1
            curr?.let { it ->
                if (it.amount > 0) {
                    heap.add(it)
                }
            }
            curr = next
        }
        curr?.let {
            if (it.amount > 0) {
                return ""
            }
        }
        return result.toString()
    }
}

data class LetterCounts(val char: Char, var amount: Int)