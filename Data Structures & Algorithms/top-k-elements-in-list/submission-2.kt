class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { number ->
            if (freq.contains(number)) {
                freq[number] = freq[number]!! + 1
            } else {
                freq[number] = 1
            }
        }
        val reversedFreq = mutableMapOf<Int, MutableList<Int>>()
        freq.forEach { k, v ->
            if (reversedFreq.contains(v)) {
                reversedFreq[v]!!.add(k)
            } else {
                reversedFreq[v] = mutableListOf(k)
            }
        }
        val sorted = reversedFreq.keys.sortedDescending()
        val ans = mutableListOf<Int>()
        var i = 0
        var pointer = 0
        while (i < k) {
            val extractArray = reversedFreq[sorted[pointer]]!!
            i += extractArray.size
            pointer += 1
            ans.addAll(extractArray)
        }
        return ans.toIntArray()
    }
}
