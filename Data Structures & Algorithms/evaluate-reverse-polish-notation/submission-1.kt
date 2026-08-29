class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        var stack = mutableListOf<Int>()
        tokens.forEach { token ->
            if (token.toIntOrNull() != null) {
                stack.add(token.toIntOrNull()!!)
            } else if (token ==  "+") {
                val elem2 = stack.last()
                stack.removeLast()
                val elem1 = stack.last()
                stack.removeLast()
                val newVal = elem1 + elem2
                stack.add(newVal)
            } else if (token == "-") {
                val elem2 = stack.last()
                stack.removeLast()
                val elem1 = stack.last()
                stack.removeLast()
                val newVal = elem1 - elem2
                stack.add(newVal)
            } else if (token == "*") {
                val elem2 = stack.last()
                stack.removeLast()
                val elem1 = stack.last()
                stack.removeLast()
                val newVal = elem1 * elem2
                stack.add(newVal)
            } else if (token == "/") {
                val elem2 = stack.last()
                stack.removeLast()
                val elem1 = stack.last()
                stack.removeLast()
                val newVal = elem1 / elem2
                stack.add(newVal)
            }
        }

        return stack[0]
    }
}
