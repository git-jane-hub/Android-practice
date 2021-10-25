package org.ict.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

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

        tpHour = tp.getHour();
        tpMinutes = tp.getMinute();
        dpYear = dp.getYear();
        dpMonth = dp.getMonth() + 1;
        dpDay = dp.getDayOfMonth();

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInTxt.setText(dpYear + "/" + dpMonth + "/" + dpDay + " " + tpHour + ":" + tpMinutes);
                checkOut.setEnabled(true);
                checkIn.setEnabled(false);
            }
        });
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOutTxt.setText(dpYear + "/" + dpMonth + "/" + dpDay + " " + tpHour + ":" + tpMinutes);
            }
        });
    }
}