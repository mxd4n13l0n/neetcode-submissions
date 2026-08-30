class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = mutableListOf<Pair<Int, Int>>()
        for (i in 0..position.lastIndex) {
            cars.add(Pair(position[i], speed[i]))
        }
        val soretedCars = cars.sortedByDescending { it.first }
        val stackOfTimes = mutableListOf<Double>()
        soretedCars.forEach { carData ->
            val calculatedTime = (target - carData.first).toDouble() / carData.second
            
            if (stackOfTimes.isEmpty() || calculatedTime > stackOfTimes.last()) {
                stackOfTimes.add(calculatedTime)
            }
        }
        return stackOfTimes.size
    }
}
