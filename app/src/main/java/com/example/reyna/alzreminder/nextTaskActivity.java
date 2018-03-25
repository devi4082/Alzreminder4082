package com.example.reyna.alzreminder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.TimeZone;

public class nextTaskActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText datePick, timePick;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private EditText title, desc;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_task);

        title = (EditText) findViewById(R.id.tulis);
        desc = (EditText) findViewById(R.id.isi);
        datePick = (EditText) findViewById(R.id.inputDate);
        timePick = (EditText) findViewById(R.id.inputTime);
        datePick.setOnClickListener(this);
        timePick.setOnClickListener(this);

        btn = (Button) findViewById(R.id.save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleValue = title.getText().toString();
                String descValue = desc.getText().toString();
                String dateValue = datePick.getText().toString();
                String timeValue = timePick.getText().toString();
                Intent intent = new Intent(nextTaskActivity.this, addTaskActivity.class);
                intent.putExtra("TITLE", titleValue);
                intent.putExtra("DESC", descValue);
                intent.putExtra("DATE", dateValue);
                intent.putExtra("CLOCK", timeValue);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick (View view) {
        if (view == datePick){

            final Calendar calendar = Calendar.getInstance();
            mYear= calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    datePick.setText(day+"-"+(month+1)+"-"+year);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (view == timePick){
            final Calendar calendar = Calendar.getInstance();
            mHour = calendar.get(Calendar.HOUR_OF_DAY);
            mMinute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    timePick.setText(hour+" : "+minute);
                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
