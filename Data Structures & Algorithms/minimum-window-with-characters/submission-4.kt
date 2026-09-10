class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) {
            return ""
        }
        var tMap = mutableMapOf<Char, Int>()
        var sMap = mutableMapOf<Char, Int>()
        val need = t.toSet().size
        var l = 0
        var have = 0
        var result = Pair(-1, -1)
        var lenResult = Int.MAX_VALUE
        t.forEach { c ->
            tMap[c] = tMap.getOrDefault(c, 0) + 1
        }

        for (r in 0..s.lastIndex) {
            sMap[s[r]] = sMap.getOrDefault(s[r], 0) + 1
            if (tMap.contains(s[r]) && tMap[s[r]] == sMap[s[r]]) {
                have += 1
                while (need == have) {
                        val len = r - l + 1
                        if (len < lenResult) {
                            result = Pair(l, r)
                            lenResult = len
                        }
                        sMap[s[l]] = sMap.getOrDefault(s[l], 1) - 1
                        if (tMap.contains(s[l]) && sMap[s[l]]!! < tMap[s[l]]!!) {
                            have -= 1
                        }
                        l += 1
                    }
            }
        }
        if (result.first < 0) {
            return ""
        }
        return s.substring(result.first, result.second + 1)
    }
}
