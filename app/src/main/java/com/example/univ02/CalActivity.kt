package com.example.univ02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        title = "초간단 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMulti)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()){
                Toast.makeText(this,"숫자를 입력하세요. ", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toInt() + num2.toInt()
                textResult.setText("계산 결과 : " + result.toString())
            }
        }

        btnSub.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()){
                Toast.makeText(this,"숫자를 입력하세요. ", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toInt() - num2.toInt()
                textResult.setText("계산 결과 : " + result.toString())
            }
        }

        btnMul.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()){
                Toast.makeText(this,"숫자를 입력하세요. ", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toInt() * num2.toInt()
                textResult.setText("계산 결과 : " + result.toString())
            }
        }

        btnDiv.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()){
                Toast.makeText(this,"숫자를 입력하세요. ", Toast.LENGTH_SHORT).show()
            }else if (num1.toInt() == 0 || num2.toInt() == 0) {
                Toast.makeText(this,"0으로 나눌 수 없습니다 ", Toast.LENGTH_SHORT).show()
            }else{
                result = num1.toInt() / num2.toInt()
                textResult.setText("계산 결과 : " + result.toString())
            }
        }
    }
}