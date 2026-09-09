class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var letters = mutableMapOf<Char, Int>()
        var l = 0
        var r = 0
        var longest = 0
        var maxF = 0
        while (l <= r && r <= s.lastIndex) {
            val letterCount = letters.getOrDefault(s[r], 0) + 1
            letters[s[r]] = letterCount
            maxF = Math.max(maxF, letterCount)
            val windowSize = r - l + 1
            if (windowSize - maxF <= k) { // still valid
                longest = Math.max(longest, windowSize)
                r += 1
            } else {
                letters[s[l]] = letters.getOrDefault(s[l], 1) - 1
                l += 1
                r += 1
            }
        }
        return longest
    }
}
