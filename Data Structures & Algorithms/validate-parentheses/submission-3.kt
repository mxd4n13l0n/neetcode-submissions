class Solution {
    fun isValid(s: String): Boolean {
        val opening = setOf('(', '{', '[')
        val closesVsOpens = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '[',
        )
        var stack = mutableListOf<Char>()
        s.forEach { character ->
            if (opening.contains(character)) {
                stack.add(character)
            } else {
                if (stack.size == 0) {
                    return false
                }
                val peek = stack.last()
                val expectedPeek = closesVsOpens[character]!!
                if (peek == expectedPeek) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }

        return stack.size == 0
    }
}
