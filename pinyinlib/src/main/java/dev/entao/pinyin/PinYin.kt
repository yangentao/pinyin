package dev.entao.pinyin

object PinYin {
    private val map: HashMap<Char, String> = HashMap(30000)

    init {
        for (s in __PinYinData) {
            parseData2(s)
        }
    }

    fun get(ch: Char): String? {
        return map[ch]
    }

    private fun parseData2(pinYinData: String) {
        val buf = StringBuilder(64)
        var code: Char = 0.toChar()
        var needCode = true
        for (ch in pinYinData) {
            if (ch == ' ') {
                continue
            }
            if (ch == '\n' || ch == '\r') {
                if (buf.isNotEmpty()) {
                    map[code] = buf.toString()
                    buf.setLength(0)
                }
                needCode = true
                continue
            }
            if (needCode) {
                code = ch
                needCode = false
            } else {
                buf.append(ch)
            }
        }
        if (buf.isNotEmpty()) {
            map[code] = buf.toString()
        }

    }

}