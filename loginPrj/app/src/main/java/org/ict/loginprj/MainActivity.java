package org.ict.loginprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userId, userPw;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = (EditText)findViewById(R.id.userId);
        userPw = (EditText)findViewById(R.id.userPw);
        submitBtn = (Button)findViewById(R.id.submitBtn);


        String str = "android";
        List<String> strs = new ArrayList<>();
        strs.add("android");
        strs.add("ios");
        strs.add("and");
        strs.add("roid");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userId.getText().toString();
                String pw = userPw.getText().toString();
                Intent intent;
                if(strs.contains(id) && pw.equals(str)){
                    Log.d("result 값: ", "ID: " + id + ", PW: " + pw);
                    intent = new Intent(getApplicationContext(), SuccessActivity.class);
                    intent.putExtra("result", "로그인에 성공하셨습니다.\n" + id + "님 환영합니다.");

                }else{
                    Log.d("result 값: ", "ID: " + id + ", PW: " + pw);
                    intent = new Intent(getApplicationContext(), FailActivity.class);
                    intent.putExtra("result", "로그인에 실패했습니다.");

                }
                startActivity(intent);
            }
        });
    }
}