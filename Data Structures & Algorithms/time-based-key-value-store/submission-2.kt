class TimeMap() {
    val values = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val pair = Pair(timestamp, value)
        if (values.contains(key)) {
            values[key]!!.add(pair)
        } else {
            values[key] = mutableListOf<Pair<Int, String>>(pair)
        }
    }

    fun get(key: String, timestamp: Int): String {
        if (values.contains(key)) {
            return searchLargestValueWithTimestamp(values[key]!!, timestamp)
        } else {
            return ""
        }
    }

    private fun searchLargestValueWithTimestamp(searchList: MutableList<Pair<Int, String>>, timestamp: Int): String {
        /* 10 20 30 */
        var l = 0
        var r = searchList.lastIndex
        if (searchList[l].first > timestamp) {
            return ""
        }
        while (l <= r) {
            val m = (l + r) / 2
            val current = searchList[m]
            if (current.first == timestamp) {
                return current.second
            }
            if (current.first > timestamp) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return searchList[r].second
    }
}
