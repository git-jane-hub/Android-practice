package org.ict.interactprj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        submitBtn = (Button)findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no1 = num1.getText().toString();
                String no2 = num2.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                //intent.putExtra("num1", Integer.parseInt(num1.getText().toString()));
                //intent.putExtra("num2", Integer.parseInt(num2.getText().toString()));
                intent.putExtra("num1", no1);
                intent.putExtra("num2", no2);


                // startActivity(intent);
                // SubActivity 에서 돌아오기 버튼을 눌렀을 때 추가로 돌려받을 값이 존재할 때 사용
                startActivityForResult(intent, 0);
            }
        });
    }

    // 어플을 처음켜서 MainActivity 에 접근한 것이 아니기 때문에 onCreate가 아닌 onActivityResult를 오버라이딩
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // RESULT_OK 가 들어오는 경우에만 화면에 결과값을 표기하도록 처리
        if(resultCode == RESULT_OK){
            // onActivityResult의 파라미터로 선언된 Intent data가 SubActivity에서 setResult()로 보낸 데이터와 함께 전달됨
            int resultNum = data.getIntExtra("resultNum", 0);
            Log.d("resultNum", resultNum + "");
            Toast.makeText(this, resultNum + "", Toast.LENGTH_SHORT).show();
        }
    }
}