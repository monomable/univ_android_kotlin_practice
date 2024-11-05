package com.example.univ02

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TextBoxActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbox)
        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener{
            var versionArray = arrayOf("과자", "음료수", "밥")
            var checkArray = booleanArrayOf(true, false, false)
            var dlg = AlertDialog.Builder(this@TextBoxActivity)
            dlg.setTitle("제목입니다.")
            //dlg.setMessage("이곳이 내용입니다")
            dlg.setIcon(R.mipmap.ic_launcher)
            /*
            dlg.setPositiveButton("확인") { dialog, which ->
                Toast.makeText(this@TextBoxActivity, "확인을 눌렀네요", Toast.LENGTH_SHORT).show()

            }
            dlg.setSingleChoiceItems(versionArray, 0){ dialog, which ->
                button1.text = versionArray[which]

            }*/

            dlg.setMultiChoiceItems(versionArray, checkArray) { dialog, which, isChecked ->
                button1.text = versionArray[which]
            }

            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }
    }
}