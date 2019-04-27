package dev.entao.utilapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.entao.kan.pinyin.Spell

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val s = Spell.get("张飞")
        println(s)
    }


}
