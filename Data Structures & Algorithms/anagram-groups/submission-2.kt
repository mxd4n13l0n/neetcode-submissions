class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var hashes = mutableMapOf<List<Int>, MutableList<String>>()
        strs.forEach { word ->
            val hashNum = hashWord(word)
            if (!hashes.containsKey(hashNum)) {
                hashes[hashNum] = mutableListOf(word)
            } else {
                hashes[hashNum]!!.add(word)
            }
        }
        val result = mutableListOf<List<String>>()
        hashes.values.forEach { value ->
            result.add(value)
        }
        return result
    }

    fun hashWord(word: String): List<Int> {
        var result = Array<Int>(26) { 0 }

        word. forEach { character ->
            result [character - 'a'] += 1
        }

        return result.toList()
    }
}
