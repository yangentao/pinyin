package dev.entao.kan.pinyin

import android.app.Application
import android.content.res.AssetManager

//使用前先设置PinYin.app
object PinYin {
    private val cacheMap = HashMap<Char, String>(25000)
    //0:Init, 1:Loading, 2:Loaded
    private var status: Int = 0
    var app: Application? = null

    private fun preLoad() {
        val ap = this.app ?: throw IllegalStateException("请先设置PinYin.app属性")
        if (this.status != 0) {
            return
        }
        this.status = 1
        try {
            val inStream = ap.assets.open("yang_pinyin.data", AssetManager.ACCESS_BUFFER)
            val br = inStream.bufferedReader()
            br.forEachLine { line ->
                if (line.length >= 3) {
                    val ch = line[0]
                    val py = line.substring(2)
                    this.cacheMap[ch] = py
                }
            }
            inStream.close()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        this.status = 2
    }

    fun findOne(ch: Char): String? {
        if (this.status != 2) {
            this.preLoad()
        }
        return this.cacheMap[ch]
    }


}