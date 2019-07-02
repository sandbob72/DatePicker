package com.example.datepicker

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker
import android.widget.Toast
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var singleBuilder = SingleDateAndTimePickerDialog.Builder(this)
        var simpleDF = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())


        singleLayout.setOnClickListener {
            singleBuilder
                .title("กรุณาเลือกวันเกิด")
                .titleTextColor(Color.BLACK)
                .mainColor(Color.BLACK)
                .bottomSheet()
                .curved()
                .displayMinutes(false)
                .displayHours(false)
                .displayDays(false)
                .displayMonth(true)
                .displayYears(true)
                .displayDaysOfMonth(true)
                .displayListener(SingleDateAndTimePickerDialog.DisplayListener{
                    //retrieve the SingleDateAndTimePicker
                })
                .listener (SingleDateAndTimePickerDialog.Listener {
                    singleText.setText(simpleDF.format(it))
                })
                .display()

        }

    }

}