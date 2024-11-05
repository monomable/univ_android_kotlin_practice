package com.example.univ02

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        val checkBox: CheckBox = findViewById(R.id.andriod)

        checkBox.setOnCheckedChangeListener{ compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this, "checkBox is Checked", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "checkBox is unchecked", Toast.LENGTH_SHORT).show()
            }
        }


    }
}