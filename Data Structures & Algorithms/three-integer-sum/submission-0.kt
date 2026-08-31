class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.sorted()
        val results = mutableSetOf<List<Int>>()
        for (i in 0..nums.lastIndex - 2) {
            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = sortedNums[i] + sortedNums[j] + sortedNums[k]
                if (sum == 0) {
                    results.add(listOf(sortedNums[i], sortedNums[j], sortedNums[k]))
                    k -= 1
                } else if (sum > 0) {
                    k -= 1
                } else {
                    j += 1
                }
            }
        }
        return results.toList()
    }
}
