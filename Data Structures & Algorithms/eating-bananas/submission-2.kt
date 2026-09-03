class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()
        var minimumK = r
        while (l <= r) {
            val k = (l + r) / 2
            val hours = calculateHoursForRate(piles, k)
            if (hours > h) {
                l = k + 1
            } else {
                r = k - 1
                minimumK = k
            }
        }
        return minimumK
    }

    private fun calculateHoursForRate(piles: IntArray, rate: Int): Int {
        var hours = 0
        piles.forEach { pile ->
            hours += pile / rate
            if (pile % rate > 0) {
                hours += 1
            }
        }
        return hours
    }
}
