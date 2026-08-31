class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var largest = 0
        var stack = mutableListOf<Pair<Int, Int>>()
        for (i in 0..heights.lastIndex) {
            val currentHeight = heights[i]
            var lastIndex = i
            while(!stack.isEmpty() && stack.last().second > currentHeight) {
                    val lastPop = stack.last()
                    stack.removeLast()
                    val width = i - lastPop.first
                    val height = lastPop.second
                    val area = width * height
                    if (largest < area) {
                        largest = area
                    }
                    lastIndex = lastPop.first
                }
                // do not add if the heights are the same
                if (stack.isEmpty() || currentHeight != stack.last().second) {
                    stack.add(Pair(lastIndex, currentHeight))
                }
        }

        stack.forEach { s ->
            println("remainder in stack: i: ${s.first}, height: ${s.second}")
            val width = heights.size - s.first
            val height = s.second
            val area = width * height
            if (largest < area) {
                largest = area
            }
        }

        return largest
    }
}
