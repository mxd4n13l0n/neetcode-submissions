class Solution {
    fun trap(height: IntArray): Int {
        var water = 0
        val maxToTheLeft = IntArray(height.size) { 0 }
        val maxToTheRight = IntArray(height.size) { 0 }

        var maxLeft = 0
        for (i in 0..height.lastIndex) {
            maxToTheLeft[i] = maxLeft
            if (height[i] > maxLeft) {
                maxLeft = height[i]
            }
        }

        var maxRight = 0
        for (i in height.lastIndex downTo 0) {
            maxToTheRight[i] = maxRight
            if (height[i] > maxRight) {
                maxRight = height[i]
            }
        }

        for (i in 0..height.lastIndex) {
            val waterToBeCapturedOnIth = min(maxToTheLeft[i], maxToTheRight[i]) - height[i]
            if (waterToBeCapturedOnIth > 0) {
                water += waterToBeCapturedOnIth
            }
        }

        return water
    }
}
