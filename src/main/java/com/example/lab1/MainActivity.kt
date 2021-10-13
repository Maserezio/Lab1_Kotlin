package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Button

import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc_btn:Button = findViewById(R.id.calc_btn)
        val sec:TextView = findViewById(R.id.sec)
        val res:TextView = findViewById(R.id.res)

        calc_btn?.setOnClickListener{
            val av = AvCounter()
            val avg = av.countAv()
            sec?.text = "${av.rvalues}"
            if (avg.isNaN()) res?.text = "0,0" else res?.text = "${"%.1f".format(avg)}"
        }
    }
}

class AvCounter {
    val rvalues = List<Int>(10) { Random.nextInt(0, 100)}
    fun countAv():Double {
        return rvalues
            .withIndex()
            .filter { (i, value) -> i % 2 != 0 }
            .map { (i, value) -> value }
            .filter { x -> x % 2 == 0 }
            .average()

    }
}