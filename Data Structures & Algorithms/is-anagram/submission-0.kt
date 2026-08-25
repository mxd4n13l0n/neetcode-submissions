class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val chars = mutableMapOf<Char, Int>()
        s.forEach { letter ->
            if (chars[letter] == null) {
                chars[letter] = 1
            } else {
                chars[letter] = chars[letter]!! + 1
            }
        }
        t.forEach { letter ->
            if (chars[letter] == null) {
                return false
            }
            chars[letter] = chars[letter]!! - 1
        }
        chars.forEach { (key, value) ->
            if (value != 0) {
                return false
            }
        }
        return true
    }
}
