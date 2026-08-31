class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.lastIndex
        while (l < r) {
            val calculated = numbers[l] + numbers[r]
            if (target == calculated) {
                return intArrayOf(l + 1, r + 1)
            }
            if (calculated > target) {
                r -= 1
            } else {
                l += 1
            }
        }
        return IntArray(0)
    }
}
