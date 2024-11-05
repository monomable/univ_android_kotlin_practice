package com.example.univ02

import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class DiaryActivity : AppCompatActivity() {
    lateinit var dp : DatePicker
    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_diary)

        btnWrite = findViewById(R.id.btnWrite)
        dp = findViewById(R.id.datePicker1)
        edtDiary = findViewById(R.id.edit)

        val cal = Calendar.getInstance()
        val cYear = cal.get(Calendar.YEAR)
        val cMonth = cal.get(Calendar.MONTH)
        val cDay = cal.get(Calendar.DAY_OF_MONTH)

        fileName = "${cYear}_${cMonth + 1}_$cDay.txt"
        displayDiary(fileName)

        dp.init(cYear, cMonth, cDay) { _, year, month, day ->
            fileName = "${year}_${month + 1}_$day.txt"
            displayDiary(fileName)
        }

        btnWrite.setOnClickListener{ saveDiary() }
    }

    private fun displayDiary(fName: String) {
        val diaryText = readDiary(fName)
        edtDiary.setText(diaryText)
        btnWrite.text = if (diaryText != null) "수정하기" else "새로 저장"
        edtDiary.hint = diaryText ?: "일기 없음"
        btnWrite.isEnabled = true

    }

    private fun saveDiary() {
        try {
            openFileOutput(fileName, Context.MODE_PRIVATE).use { it.write(edtDiary.text.toString().toByteArray())}
            Toast.makeText(this, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "파일 저장에 실패했습니다: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readDiary(fName: String): String? {
        return try {
            openFileInput(fName).bufferedReader().use { it.readText().trim() }
        }catch (e: IOException) {
            null
        }
    }
}