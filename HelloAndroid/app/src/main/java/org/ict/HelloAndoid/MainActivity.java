package org.ict.HelloAndoid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 이벤트 처리를 위한 Button 객체 선언(window + enter)
    Button button1;
    Button button2;

    @Override
    // 메인메서드의 역할을 함
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button1 클릭시 이벤트 발생하도록 연결
        // button1과 findViewById의 자료형이 같지 않기 때문에 같은 자료형으로 만들어줘야함
        // R.id.뒤에는 activity_main.xml에 작성한 Button태그의 android:id를 작성
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            // 실제 일어나는 이벤트는 onclick 메서드에 작성
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "가로버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "세로버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }



}