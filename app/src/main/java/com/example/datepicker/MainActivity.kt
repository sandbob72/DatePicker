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
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c = Calendar.getInstance()
        var singleYear = SimpleDateFormat("yyyy", Locale.getDefault())
        var y = singleYear.format(c.time)
        var nowYaer = y.toInt() + 543

        var singleBuilder = SingleDateAndTimePickerDialog.Builder(this)
        var singleDF = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

        var calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR,nowYaer)
        var defaultDate = calendar.time




        singleLayout.setOnClickListener {
            singleBuilder
                .title("กรุณาเลือกวันเกิด")
                .titleTextColor(Color.BLACK)
                .titleTextSize(15)
                .mainColor(Color.BLACK)
                .bottomSheet()
                .curved()
                .mustBeOnFuture()
                .defaultDate(defaultDate)
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
                    singleText.setText(singleDF.format(it))
                })
                .display()

        }

    }

}
