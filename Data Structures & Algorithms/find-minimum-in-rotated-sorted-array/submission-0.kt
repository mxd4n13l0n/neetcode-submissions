class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            var mid = (l + r) / 2
            if (nums[mid] < nums[r]) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return nums[l]
    }
}
