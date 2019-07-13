package dev.entao.utilapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.entao.kan.pinyin.PinYin

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PinYin.app = this.application
        val a = System.currentTimeMillis()
        val s = PinYin.findOne('长') ?: ""
        val b = System.currentTimeMillis()

        println(b - a)
        println("[" + s + "]")
    }


}
