class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 0) {
            return 0
        }

        var longest = 1
        var charSet = mutableSetOf<Char>()
        charSet.add(s[0])
        var l = 0
        var r = Math.min(l + 1, s.lastIndex)
        /*
        max 2
        l = 0, r = 2
        [p w]
        */
        while (l <= r && r <= s.lastIndex) {
            if (charSet.contains(s[r])) {
                charSet.remove(s[l])
                l += 1
            } else {
                charSet.add(s[r])
                longest = Math.max(longest, r - l + 1)
                r += 1
            }
        }
        return longest
    }
}
