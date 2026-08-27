class Solution {
    val glue = '#'
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        strs.forEach { word ->
            val chunk = "${word.length}${glue}$word"
            builder.append(chunk)
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var index = 0
        while (index < str.length) {
            val currentSubString = str.substring(index, str.length)
            val delimiterIndex = currentSubString.indexOf(glue)
            val counter = currentSubString.substring(0, delimiterIndex).toInt()
            val word = currentSubString.substring(delimiterIndex + 1, (delimiterIndex + 1) + counter)
            result.add(word)
            index += counter + delimiterIndex + 1
        }
        return result
    }
}
