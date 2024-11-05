package com.example.univ02

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    lateinit var  baseLayout : LinearLayout
    lateinit var  button1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        title = "배경색 바꾸기"
        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
        button1 = findViewById<Button>(R.id.button1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemRed -> {
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }

            R.id.itemBlue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }

            R.id.itemGreen -> {
                baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }

            R.id.subSize -> {
                button1.scaleX = 2f
                return true
            }

            R.id.subRotate -> {
                button1.rotation = 45f
                return true
            }
        }
        return false
    }
}