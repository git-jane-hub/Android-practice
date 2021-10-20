package org.ict.widgetprj3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        btn1 = (Button)findViewById(R.id.btn1);
        tv1 = (TextView)findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Button", "버튼이 클릭되었습니다.");
                //Toast.makeText(getApplicationContext(), "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();

                String Result = et1.getText().toString();
                Log.i("Button", Result);

                Toast.makeText(getApplicationContext(), "입력한값: " + Result, Toast.LENGTH_SHORT).show();
                // TextView에 Result변수에 담긴 값을 추가
                tv1.setText(Html.fromHtml("입력한 값<br>: " + Result));
                tv1.setTextSize(30);
            }
        });

    }
}