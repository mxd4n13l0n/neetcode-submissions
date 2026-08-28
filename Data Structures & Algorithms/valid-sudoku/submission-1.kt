class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return isValidHorizontals(board) && isValidVerticals(board) && isValidOnSquares(board)
    }

    fun isValidHorizontals(board: Array<CharArray>): Boolean {
        for(y in 0..8) {
            val setHorizontals = mutableSetOf<Int>()
            for (x in 0..8) {
                val currentChar = board[y][x]
                if (currentChar == '.') {
                    continue
                }
                val currentNum = currentChar.toInt()
                if (setHorizontals.contains(currentNum)) {
                    return false
                } else {
                    setHorizontals.add(currentNum)
                }
            }
        }
        return true
    }

    fun isValidVerticals(board: Array<CharArray>): Boolean {
        for(x in 0..8) {
            val setVerticals = mutableSetOf<Int>()
            for (y in 0..8) {
                val currentChar = board[y][x]
                if (currentChar == '.') {
                    continue
                }
                val currentNum = currentChar.toInt()
                if (setVerticals.contains(currentNum)) {
                    return false
                } else {
                    setVerticals.add(currentNum)
                }
            }
        }
        return true
    }

    fun isValidOnSquares(board: Array<CharArray>): Boolean {
        for(yProd in 0..2) {
            for(xProd in 0..2) {
                val setSquares = mutableSetOf<Int>()
                for (y in 0..2) {
                    for (x in 0..2) {
                        val currentChar = board[y + yProd*3][x + xProd*3]
                        if (currentChar == '.') {
                            continue
                        }
                        val currentNum = currentChar.toInt()
                        if (setSquares.contains(currentNum)) {
                            return false
                        } else {
                            setSquares.add(currentNum)
                        }
                    }
                }
            }
        }
        return true
    }
}
