package org.ict.widgetprj7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer cm;
    Button start, stop, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cm = (Chronometer)findViewById(R.id.cm);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        reset = (Button)findViewById(R.id.reset);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.stop();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setBase(SystemClock.elapsedRealtime());
                cm.stop();
            }
        });
    }
}