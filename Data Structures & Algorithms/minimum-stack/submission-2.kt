class MinStack() {
    private val stack = mutableListOf<Int>()
    private var minStack = mutableListOf<Int>()

    fun push(value: Int) {
        stack.add(value)
        if (minStack.size == 0) {
            minStack.add(value)
        } else {
            if (value <= minStack.last()) {
                minStack.add(value)
            }
        }
    }

    fun pop() {
        val lastOnTop = stack.last()
        stack.removeLast()
        if (lastOnTop == minStack.last()) {
            minStack.removeLast()
        }
    }

    fun top(): Int {
        val lastOnTop = stack.last()
        return lastOnTop
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
