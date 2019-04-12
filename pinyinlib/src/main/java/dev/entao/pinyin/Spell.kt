package dev.entao.pinyin

/**
 * Created by entaoyang@163.com on 2016-08-06.
 */


object Spell {
	val map = HashMap<String, String>(128)
	fun get(ss: String?): String? {
		val s = ss ?: return null
		val v = map.get(s)
		if (v != null) {
			return v
		}
		val sb = StringBuilder(8)
		for (ch in s) {
			val c = PinYin.get(ch) ?: "#"
			sb.append(c)
		}
		val value = sb.toString()
		map[s] = value
		return value
	}

}
