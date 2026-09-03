class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val height = matrix.size
        val width = matrix[0].size
        var l = 0
        var r = height * width - 1
        /* 
        1 3 5 7 10 11 16 20 23 30 34 60 
        middle: 3
        l 1
        r 3
        7 > 3?
        */
        while (l <= r) {
            val middle = (l + r) / 2
            val y = middle / width
            val x = middle % width
            println("x: {$x}, y: ${y}")
            val value = matrix[y][x]
            if (value > target) {
                r = middle - 1
            } else if (value < target) {
                l = middle + 1
            } else {
                return true
            }
        }
        return false
    }
}
