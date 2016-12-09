package com.example.a403.myapplication;

import java.util.Calendar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal,rdoTime;
    CalendarView calendar;
    TimePicker time;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = (Chronometer)findViewById(R.id.chronometer1);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);
        calendar = (CalendarView)findViewById(R.id.calendarView1);
        time = (TimePicker)findViewById(R.id.timePicker1);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView)findViewById(R.id.tvMinute);

        calendar.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(calendar.getDate());
                tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
                tvMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
                tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));

                tvHour.setText(Integer.toString(time.getCurrentHour()));
                tvMinute.setText(Integer.toString(time.getCurrentMinute()));
            }
        });
    }
}
