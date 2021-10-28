package org.ict.dialogprj2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userNameTv, userEmailTv;
    Button openBtn;
    EditText userNameEt, userEmailEt;
    //
    View modal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTv = (TextView)findViewById(R.id.userNameTv);
        userEmailTv = (TextView)findViewById(R.id.userEmailTv);
        openBtn = (Button)findViewById(R.id.openBtn);

        // 클릭하면 모달같이 userinfo.xml이 열려야함
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inflate() 기능을 이용해 xml파일을 화면으로 가져옴
                // userinfo를 MainActivity에 표현하겠다는 의미
                modal = (View)View.inflate(MainActivity.this, R.layout.userinfo, null);

                // AlertDialog 객체를 생성하고 가져온 View를 다이어로그로 변경
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(modal);
                // 확인 취소버튼 생성
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // inflate로 만든 커스텀 창의 위젯은 modal명으로 연결
                        userNameEt = (EditText)modal.findViewById(R.id.userNameEt);
                        userEmailEt = (EditText)modal.findViewById(R.id.userEmailEt);

                        userNameTv.setText(userNameEt.getText() + "");
                        userEmailTv.setText(userEmailEt.getText() + "");
                    }
                });
                dlg.setNegativeButton("cancel", null);
                // 화면에 출력
                dlg.show();
            }
        });



    }
}