class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var a = nums[0]
        var b = nums[0]
        b = nums[b]
        var c = 0
        while (a != b) {
            a = nums[a]
            b = nums[b]
            b = nums[b]
        }

        while (b != c) {
            b = nums[b]
            c = nums[c]
        }
        
        return c
    }
}
