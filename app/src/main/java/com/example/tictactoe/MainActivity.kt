package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun strtTwo(view: View) {
         val intent = Intent(this,play2::class.java)
        startActivity(intent)
    }
    fun strtOne(view: View) {
        val intent2=Intent(this,play1::class.java)
        startActivity(intent2)
    }
}