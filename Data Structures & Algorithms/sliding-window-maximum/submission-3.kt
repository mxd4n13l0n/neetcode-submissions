class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val windowMax = ArrayDeque<Int>()
        for (i in 0..k - 1) {
            val num = nums[i]
            while(windowMax.isNotEmpty() && windowMax.last() < num) {
                windowMax.removeLast()
            }
            windowMax.addLast(num)
        }
        windowMax.forEach { i ->
            println(i)
        }

        val result = mutableListOf<Int>()
        result.add(windowMax.first())

        for (i in k .. nums.lastIndex) {
            val leftMost = nums[i - k]
            if (leftMost == windowMax.first()) {
                windowMax.removeFirst()
            }
            
            val num = nums[i]
                while(windowMax.isNotEmpty() && windowMax.last() < num) {
                    windowMax.removeLast()
                }
            windowMax.addLast(num)
            result.add(windowMax.first())
        }

        return result.toIntArray()
    } 
}
