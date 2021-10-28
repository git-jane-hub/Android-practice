package org.ict.dialogprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogBtn = (Button)findViewById(R.id.dialogBtn);

        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 선택지는 리스트로 관리
                final String[] animalArray = new String[]{"고양이", "강아지", "토끼"};
                // 대화상자 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                // setting
                dlg.setTitle("title");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                // 내용은 위의 리스트를 감지한 인덱스에 따라 출력해주도록 작성
                /* 단순 선택지
                dlg.setItems(animalArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.d("clicked", which + "");   // 0, 1, 2가 출력됨
                        // 클릭된 것을 감지하는 것은 which - array에 적용
                        Toast.makeText(MainActivity.this, animalArray[which] + "", Toast.LENGTH_SHORT).show();
                    }
                });
                 */
                /* 라디오 버튼
                dlg.setSingleChoiceItems(animalArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this, animalArray[which] + "", Toast.LENGTH_SHORT).show();
                    }
                });
                */
                // 체크박스 형식은 선택-true, 안됨-false로 default값을 설정
                final boolean[] checkArray = {false, false, false};
                dlg.setMultiChoiceItems(animalArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        Log.d("checked", isChecked + "");
                        if(isChecked){
                            Toast.makeText(MainActivity.this, animalArray[which] + "가 체크됨", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, animalArray[which] + "가 체크해제됨", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setPositiveButton("close", null);
                // 화면 출력
                dlg.show();
            }
        });

        /* 단일 경고창(선택지가 없음)
        // 클릭하면 모달창이 열리도록
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                // setting
                dlg.setTitle("title");
                dlg.setMessage("contents");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                // 확인 버튼 추가
                //dlg.setPositiveButton("check", null);

                // 버튼에 onclick 이벤트 추가
                // 확인
                dlg.setPositiveButton("check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "checked!!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                // 취소
                dlg.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "cancel!!!!!!", Toast.LENGTH_SHORT).show();
                    }
                });

                // 화면 출력
                dlg.show();
            }
        });
        */
    }
}