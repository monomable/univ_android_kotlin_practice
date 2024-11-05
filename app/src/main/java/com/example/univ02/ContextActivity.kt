package com.example.univ02

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ContextActivity : AppCompatActivity() {
    private lateinit var baseLayout: LinearLayout
    private lateinit var button1 : Button
    private lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)
        title = "컨텍스트 메뉴"

        baseLayout = findViewById(R.id.context)
        button1 = findViewById(R.id.button1)
        registerForContextMenu(button1)
        button2 = findViewById(R.id.button2)
        registerForContextMenu(button2)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater
        if (v === button1){
            menu!!.setHeaderTitle("배경색 변경")
            mInflater.inflate(R.menu.context1, menu)
        }

        if (v === button2){
            menu!!.setHeaderTitle("아이콘 변경")
            mInflater.inflate(R.menu.context2, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
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
                button2.scaleX = 2f
                return true
            }

            R.id.subRotate -> {
                button2.rotation = 45f
                return true
            }
        }
        return false
    }


}