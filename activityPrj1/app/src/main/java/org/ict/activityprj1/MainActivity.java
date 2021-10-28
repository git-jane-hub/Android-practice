package org.ict.activityprj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // 버튼 생성
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button)findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정보 전달은 Intent 객체를 생성
                // 파라미터1: getApplicationContext(), 파라미터2: 이동할 페이지의 클래스
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                // intent에 기입된 목적지로 이동함
                // MainActivity 이외의 다른 요소를 추가할 때에는 AndroidManifest.xml에 등록해야함
                startActivity(intent);
            }
        });

    }
}