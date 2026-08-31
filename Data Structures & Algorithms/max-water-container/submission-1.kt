class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.lastIndex
        var maxArea = 0
        while(l < r) {
            val currentArea = (r - l) * minOf(heights[l], heights[r])
            if (currentArea > maxArea) {
                maxArea = currentArea
            }
            if (heights[l] < heights[r]) {
                l += 1
            } else {
                r -= 1
            }
        }
        return maxArea
    }
}
