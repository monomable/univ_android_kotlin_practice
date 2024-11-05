package com.example.univ02

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textview)

        var tv1 : TextView
        var tv2 : TextView
        var tv3 : TextView

        tv1 = findViewById<TextView>(R.id.textView1)
        tv2 = findViewById<TextView>(R.id.textView2)
        tv3 = findViewById<TextView>(R.id.textView3)

        tv1.setText("안녕하세요?")
        tv1.setTextColor(Color.RED)
        tv2.setTextSize(30.0f)
        tv2.setTypeface(android.graphics.Typeface.SERIF,
                        android.graphics.Typeface.BOLD_ITALIC)
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하")
        tv3.setMaxLines(1)
        tv3.setEllipsize(TextUtils.TruncateAt.END)
    }
}