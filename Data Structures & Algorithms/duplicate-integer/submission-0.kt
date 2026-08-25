class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val setOfNumbers = mutableSetOf<Int>()
        nums.forEach { number ->
            if (setOfNumbers.contains(number)) {
                return true
            }
            setOfNumbers.add(number)
        }
        return false
    }
}
