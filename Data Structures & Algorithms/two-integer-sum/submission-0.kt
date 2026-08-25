class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indicesFromNumbers = mutableMapOf<Int, Int>()
        for (i in 0..nums.lastIndex) {
            indicesFromNumbers[nums[i]] = i
        }
        for (i in 0..nums.lastIndex) {
            val attemptedNumber = target - nums[i]
            if (indicesFromNumbers.contains(attemptedNumber)) {
                val j = indicesFromNumbers[attemptedNumber]!!
                if (j != i) {
                    if (i < j) {
                        return intArrayOf(i, j)
                    } else {
                        return intArrayOf(j, i)
                    }
                }
            }
        }
        return intArrayOf()
    }
}
