package org.ict.toastprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button toastBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastBtn = (Button)findViewById(R.id.toastBtn);

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("button", "버튼 눌림");
                //Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show();

                // toast에 옵션을 결려면 바로 화면에 .show()를 사용하지 않음
                Toast toast = Toast.makeText(getApplicationContext(), "toast!!!!!!!!!", Toast.LENGTH_SHORT);
                // 화면 내부의 높이, 너비를 얻어올 수 있도록 display설정
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                // 나온 좌표값
                int xOffset = (int)(Math.random() * display.getWidth());
                int yOffset = (int)(Math.random() * display.getHeight());

                // Math.random()으로 얻어온 좌표값을 토스트에 적용
                // Gravity.TOP/LEFT가 적용되었으므로 좌상단이 영점으로 잡힘힘
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                // toast에 옵션을 모두 입력하고 .show()ffhj ghkaus cnffur
                toast.show();
            }
        });
    }
}