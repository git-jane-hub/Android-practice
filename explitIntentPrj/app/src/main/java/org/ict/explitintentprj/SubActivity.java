package org.ict.explitintentprj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    TextView message;
    Button nextBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        message = (TextView)findViewById(R.id.message);
        nextBtn = (Button)findViewById(R.id.nextBtn);
        cancelBtn = (Button)findViewById(R.id.cancelBtn);

        // 전달된 intent를 받으려면
        // 1. intent 자체를 변수에 저장
        Intent intent = getIntent();

        // 2. intent 내부에 같이 들어온 데이터를 빼내기 - intent.get자료형Extra("호출명")
        String getData = intent.getStringExtra("test");

        // 3. 받아온 데이터를 활용
        message.setText(getData);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), SubActivity2.class);
                //intent.putExtra("test2", getData);
                // intent를 새로 생성하지 않고 위의 intent를 수정해서 사용 - 메모리를 여러번할당하지 않아도됨
                intent.setClass(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
