class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        var stack = mutableListOf<Int>()
        var result = IntArray(temperatures.size) { 0 }
        for (i in 0..temperatures.lastIndex) {
            if (stack.isEmpty()) {
                stack.add(i)
                continue
            }

            while(!stack.isEmpty() && temperatures[stack.last()] < temperatures[i]) {
                var recoveredIndexFromStack = stack.last()
                stack.removeLast()
                result[recoveredIndexFromStack] = i - recoveredIndexFromStack
            }
            stack.add(i)
        }
        return result
    }
}
