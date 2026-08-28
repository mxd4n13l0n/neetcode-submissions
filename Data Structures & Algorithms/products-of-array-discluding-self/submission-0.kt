class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        // 1 2 4 6
        // prefix product:
        // 1 1 2 8
        // suffix product:
        // 48 24 6 1
        var prefixes = IntArray(nums.size) { 1 }
        var sufixes = IntArray(nums.size) { 1 }
        for (i in 1..nums.lastIndex) {
            prefixes[i] = prefixes[i - 1] * nums[i - 1]
        }
        for (i in nums.lastIndex - 1 downTo 0) {
            sufixes[i] = sufixes[i + 1] * nums[i + 1]
        }
        var answer = IntArray(nums.size) { 1 }
        for (i in 0..nums.lastIndex) {
            answer[i] = prefixes[i] * sufixes[i]
        }
        return answer
    }
}
