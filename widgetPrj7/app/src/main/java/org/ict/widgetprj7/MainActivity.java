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

    boolean running;
    long pause;

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
                if(!running){
                    cm.setBase(SystemClock.elapsedRealtime() - pause);
                    cm.start();
                    running = true;
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(running){
                    cm.stop();
                    pause = SystemClock.elapsedRealtime() - cm.getBase();
                    running = false;
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setBase(SystemClock.elapsedRealtime());
                cm.stop();
                pause = 0;
            }
        });
    }
}