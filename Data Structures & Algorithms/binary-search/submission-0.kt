class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val n = (l + r) / 2
            if (nums[n] < target) {
                l = n + 1
            } else if (nums[n] > target) {
                r = n - 1
            } else {
                return n
            }
        }
        return -1
    }
}
