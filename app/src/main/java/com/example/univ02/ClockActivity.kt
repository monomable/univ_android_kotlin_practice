package com.example.univ02

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class ClockActivity : AppCompatActivity() {

    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMon : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMin : TextView

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        title = "시간 예약"

        btnStart = findViewById<Button>(R.id.btnStart)
        btnEnd = findViewById<Button>(R.id.btnEnd)

        chrono = findViewById<Chronometer>(R.id.chronometer1)

        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        tPicker = findViewById<TimePicker>(R.id.timePicker1)
        calView = findViewById<CalendarView>(R.id.calendarView1)

        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMon = findViewById<TextView>(R.id.tvMon)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMin = findViewById<TextView>(R.id.tvMin)

        tPicker.visibility = View.INVISIBLE
        calView.visibility = View.INVISIBLE

        rdoCal.setOnClickListener{
            tPicker.visibility = View.INVISIBLE
            calView.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener{
            tPicker.visibility = View.VISIBLE
            calView.visibility = View.INVISIBLE
        }

        btnStart.setOnClickListener{
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }

        btnEnd.setOnClickListener{
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMon.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMin.text = Integer.toString(tPicker.currentMinute)

        }

        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month +1
            selectDay = dayOfMonth
        }

    }
}