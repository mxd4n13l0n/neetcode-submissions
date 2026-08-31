class Solution {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.lastIndex
        val validChars = mutableSetOf<Char>()
        for (char in 'A'..'Z') {
            validChars.add(char)
        }
        for (char in 'a'..'z') {
            validChars.add(char)
        }
        for (char in '0'..'9') {
            validChars.add(char)
        }
        while (l < r) {
            if (!validChars.contains(s[l])) {
                l += 1
                continue
            }
            if (!validChars.contains(s[r])) {
                r -= 1
                continue
            }
            if (s[l].lowercaseChar() != s[r].lowercaseChar()) {
                return false
            }
            l += 1
            r -= 1
        }
        return true
    }
}
