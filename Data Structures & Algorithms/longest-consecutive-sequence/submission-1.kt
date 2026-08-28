class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val mapOfSequences = mutableMapOf<Int, Int>()
        val setNums = mutableSetOf<Int>()
        nums.forEach{ number ->
            setNums.add(number)
        }

        nums.forEach { number ->
            if (!setNums.contains(number - 1)) {
                var seq = 1
                while (setNums.contains(number + seq)) {
                    seq += 1
                }
                mapOfSequences[number] = seq
            }
        }

        return mapOfSequences.values.max()
    }
}
