package org.ict.menuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout out;
    Button normalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = (LinearLayout)findViewById(R.id.out);
        normalBtn = (Button)findViewById(R.id.normalBtn);

        setTitle("Menu");
    }

    /* 외부 xml파일 등록하기
     * 커서를 onCreate 바깥에 두고 code - Override Methods 선택 - onCreateOptionsMenu 선택
     */
    // 메뉴의 옵션을 생성하는 코드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 자바 코드로 처리하기 위해 기존 코드 주석처리
        // 메뉴 추가를 위해 inflater 활용
        //MenuInflater mInflater = getMenuInflater();
        // 기존 레이아웃에 메뉴 삽입 .inflate(리소스 폴더 내 xml 파일 지정, menu);
        //mInflater.inflate(R.menu.menu1, menu);
        // groupId, itemId, order, title
        menu.add(0, 1, 0, "배경을 빨간색으로 변경");
        menu.add(0, 2, 0, "배경을 파랑색으로 변경");
        menu.add(0, 3, 0, "배경을 노란색으로 변경");
        menu.add(0, 4, 0, "배경을 초록색으로 변경");

        // 서브메뉴 추가 - 아이템아이디는 중복되면 안됨
        SubMenu sub = menu.addSubMenu("추가 옵션");
        sub.add(0, 5, 0, "버튼 45도 회전");
        sub.add(0, 6, 0, "사이즈 2배");


        return true;
    }

    Integer rotation = 0;
    // 옵션 요소가 선택되었을 때 실행할 코드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*
        Log.d("선택 item", item.getItemId() + "");
        if(item.getItemId() == 2131230809){
            out.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == 2131230807){
            out.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId() == 2131230810){
            out.setBackgroundColor(Color.YELLOW);
        }else if(item.getItemId() == 2131230808){
            out.setBackgroundColor(Color.GREEN);
        }else if(item.getItemId() == R.id.rotate){
            rotation += 45;
            normalBtn.setRotation(rotation);
        }else if(item.getItemId() == R.id.upSize){
            normalBtn.setScaleX(2);
        }
         */
        Log.d("선택", item.getItemId()+"");
        if(item.getItemId() == 0){
            out.setBackgroundColor(Color.WHITE);
        }else if(item.getItemId() == 1){
            out.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == 2){
            out.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId() == 3){
            out.setBackgroundColor(Color.YELLOW);
        }else if(item.getItemId() == 4){
            out.setBackgroundColor(Color.GREEN);
        }else if(item.getItemId() == 5){
            rotation += 45;
            normalBtn.setRotation(rotation);
        }else if(item.getItemId() == 6){
            normalBtn.setScaleX(2);
        }
        return true;
    }
}






