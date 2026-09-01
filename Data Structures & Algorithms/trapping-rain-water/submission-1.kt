class Solution {
    fun trap(height: IntArray): Int {
var water = 0
        var l = 0
        var r = height.lastIndex
        var leftMax = height[l]
        var rightMax = height[r]
        while (l < r) {
            if (leftMax < rightMax) {
                l += 1
                leftMax = max(leftMax, height[l])
                if (leftMax - height[l] > 0) {
                    water += leftMax - height[l]
                }
            } else {
                r -= 1
                rightMax = max(rightMax, height[r])
                if (rightMax - height[r] > 0) {
                    water += rightMax - height[r]
                }
            }
        }

        return water
    }
}
