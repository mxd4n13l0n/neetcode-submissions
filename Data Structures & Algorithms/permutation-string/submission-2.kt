class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }

        var mapOfS1 = mutableMapOf<Char, Int>()
        var mapOfS2 = mutableMapOf<Char, Int>()

        for (c in 'a'..'z') {
            mapOfS1[c] = 0
            mapOfS2[c] = 0
        }

        s1.forEach { letter ->
            val debug = mapOfS1.getOrDefault(letter, 0) + 1
            mapOfS1[letter] = mapOfS1.getOrDefault(letter, 0) + 1
        }

        for (i in 0 .. s1.lastIndex) {
            val c = s2[i]
            mapOfS2[c] = mapOfS2.getOrDefault(c, 0) + 1
        }

        var l = 0
        var r = s1.lastIndex
        while (r < s2.lastIndex) {
            if (mapOfS1 == mapOfS2) {
                return true
            }
            val firstChar = s2[l]
            mapOfS2[firstChar] = mapOfS2.getOrDefault(firstChar, 1) - 1
            l += 1
            r += 1
            var lastChar = s2[r]
            mapOfS2[lastChar] = mapOfS2.getOrDefault(lastChar, 0) + 1
        }
        return mapOfS1 == mapOfS2
    }
}
