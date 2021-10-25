package org.ict.pickerprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker tPicker;
    DatePicker dPicker;
    Button checkIn, checkOut;
    TextView checkInTime, checkOutTime;

    // 전역변수에 날짜정보 저장
    Integer yearInt, month, day;
    Integer hourInt, minutesInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tPicker = (TimePicker)findViewById(R.id.tPicker);
        dPicker = (DatePicker)findViewById(R.id.dPicker);
        checkIn = (Button)findViewById(R.id.checkIn);
        checkOut = (Button)findViewById(R.id.checkOut);
        checkInTime = (TextView)findViewById(R.id.checkInTime);
        checkOutTime = (TextView)findViewById(R.id.checkOutTime);

        // 날짜 정보 가져오기
        yearInt = dPicker.getYear();
        month = dPicker.getMonth() + 1;
        day = dPicker.getDayOfMonth();

        // 시간 정보 가져오기
        hourInt = tPicker.getHour();
        minutesInt = tPicker.getMinute();


        // 날짜 처리는 DatePicker에 날짜가 변할 때마다 변수에 저장
        // dPicker를 getter로 가져올 수 있음
        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                yearInt = year;
                month = monthOfYear;
                day = dayOfMonth;

                // 로그를 확인하면 월에 1을 더해줘야함을 알 수 있음
                Log.d("날짜", yearInt + "/" + month + "/" + day);
            }
        });

        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minutes) {

                hourInt = hour;
                minutesInt = minutes;
            }
        });


        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkInTxt = yearInt + "/" + month + "/" + day + " " + hourInt + ":" + minutesInt;
                checkInTime.setText(checkInTxt);
            }
        });
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkOuttxt = yearInt + "/" + month + "/" + day + " " + hourInt + ":" + minutesInt;
                checkOutTime.setText(checkOuttxt);
            }
        });
    }
}