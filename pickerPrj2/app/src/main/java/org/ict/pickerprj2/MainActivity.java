package org.ict.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    DatePicker dp;
    Button checkIn, checkOut;
    TextView checkInTxt, checkOutTxt;

    Integer tpHour, tpMinutes, dpYear, dpMonth, dpDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = (TimePicker)findViewById(R.id.tp);
        dp = (DatePicker)findViewById(R.id.dp);
        checkIn = (Button)findViewById(R.id.checkIn);
        checkOut = (Button)findViewById(R.id.checkOut);
        checkInTxt = (TextView)findViewById(R.id.checkInTxt);
        checkOutTxt = (TextView)findViewById(R.id.checkOutTxt);


        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tpHour = tp.getHour();
                tpMinutes = tp.getMinute();
                dpYear = dp.getYear();
                dpMonth = dp.getMonth() + 1;
                dpDay = dp.getDayOfMonth();

                checkInTxt.setText(dpYear + "/" + dpMonth + "/" + dpDay + " " + tpHour + ":" + tpMinutes);
                checkOut.setEnabled(true);
                checkIn.setEnabled(false);
            }
        });
        // 여기 수정해야됨
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재시간
                long now = System.currentTimeMillis();
                Date date = new Date(now);

                // 갱신
                dp.updateDate((date.getYear() + 1900), (date.getMonth()), date.getDate());
                Log.d("업데이트된 년도", (date.getYear() + 1900) + "");
                Log.d("업데이트된 월", (date.getMonth() + 1) + "");
                Log.d("업데이트된 일", date.getDate() + "");

                tp.setHour(date.getHours());
                tp.setMinute(date.getMinutes());

                tpHour = tp.getHour();
                tpMinutes = tp.getMinute();
                dpYear = dp.getYear();
                dpMonth = dp.getMonth() + 1;
                dpDay = dp.getDayOfMonth();

                checkOutTxt.setText(dpYear + "/" + dpMonth + "/" + dpDay + " " + tpHour + ":" + tpMinutes);
                checkOut.setEnabled(false);
            }
        });
    }
}