package org.ict.interactprj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    Button goback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        goback = (Button)findViewById(R.id.goback);
        Intent intent = getIntent();
        int num1 = Integer.parseInt(intent.getStringExtra("num1"));
        int num2 = Integer.parseInt(intent.getStringExtra("num2"));
        Log.d("num1: " , num1 + "");
        Log.d("num2: " , num2 + "");

        // MainActivity에서 보낸 값을 SubActivity에서 처리
        int resultNum = num1 + num2;

        // 돌아가기 버튼이 눌리면 해당 값을 보내줘야함
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 처리한 값을 MainActivity로 돌려보냄
                Intent returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("resultNum", resultNum);
                // 입력된 값은 setResult로 보내고 RESULT_OK는 상수 -1
                // setResult에 담긴 intent는 돌아가기 버튼을 누르면 MainActivity로 연결됨
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
