package org.ict.widgetprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    Button red;
    Button yellow;
    Button black;

    // 데이터타입은 대문자로 작성
    Boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연결없이 실행하면 null object reference 뜸
        tv1 = (TextView)findViewById(R.id.tv1);
        btn1 = (Button)findViewById(R.id.myName);

        red = (Button)findViewById(R.id.red);
        yellow = (Button)findViewById(R.id.yellow);
        black = (Button)findViewById(R.id.black);

        click = true;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // console debug1
                System.out.println("button clicked!");
                // console debug2 **사용**
                Log.i("Button", "button clicked!");
                Log.i("TextView", "changed text!");

                // toast debug
                Toast.makeText(getApplicationContext(), "button clicked!", Toast.LENGTH_SHORT).show();

                // toggle
                if (click) {
                    tv1.setTextSize(50);
                    tv1.setTextColor(Color.BLUE);
                    tv1.setTypeface(Typeface.SERIF);
                    tv1.setText("Gamma 최재인");
                    tv1.setBackgroundColor(Color.LTGRAY);
                    click = false;
                }else{
                    tv1.setTextSize(50);
                    tv1.setTextColor(Color.GREEN);
                    tv1.setTypeface(Typeface.SANS_SERIF);
                    tv1.setText("최재인 Gamma");
                    tv1.setBackgroundColor(Color.WHITE);
                    click = true;
                }
            }
        });

        red.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked red!", Toast.LENGTH_SHORT).show();
                tv1.setBackgroundColor(Color.RED);
                tv1.setTextColor(Color.WHITE);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked red!", Toast.LENGTH_SHORT).show();
                tv1.setBackgroundColor(Color.YELLOW);
                tv1.setTextColor(Color.BLACK);
            }
        });
        black.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked red!", Toast.LENGTH_SHORT).show();
                tv1.setBackgroundColor(Color.BLACK);
                tv1.setTextColor(Color.WHITE);
            }
        });
    }
}










