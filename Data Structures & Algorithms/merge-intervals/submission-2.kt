class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var allIntervals = mutableListOf<Interval>()
        intervals.forEach { interval ->
            allIntervals.add(Interval(interval[0], interval[1]))
        }
        val allIntervalsSorted = allIntervals.sortedBy { it.start }

        val mergedIntervals = mutableListOf<Interval>()
        mergedIntervals.add(allIntervalsSorted[0])

        allIntervalsSorted.forEach { interval ->
            val last = mergedIntervals.last()
            if (interval.start >= last.start && interval.start <= last.end) {
                val newInterval = Interval(Math.min(interval.start, last.start), Math.max(interval.end, last.end))
                mergedIntervals.removeLast()
                mergedIntervals.add(newInterval)
            } else {
                mergedIntervals.add(interval)
            }
        }
        return mergedIntervals.map<Interval, IntArray> {
            intArrayOf(it.start, it.end)
        }.toTypedArray()
    }
}

data class Interval(val start: Int, val end: Int)