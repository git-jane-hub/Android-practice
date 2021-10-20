package org.ict.lottoprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button getNum;
    TextView num1, num2, num3, num4, num5, num6, bonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNum = (Button)findViewById(R.id.getNum);

        num1 = (TextView)findViewById(R.id.num1);
        num2 = (TextView)findViewById(R.id.num2);
        num3 = (TextView)findViewById(R.id.num3);
        num4 = (TextView)findViewById(R.id.num4);
        num5 = (TextView)findViewById(R.id.num5);
        num6 = (TextView)findViewById(R.id.num6);
        bonus = (TextView)findViewById(R.id.bonus);

        getNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int [] lotto = new int [45];
                int tmp = 0;
                for(int a = 0; a < lotto.length; a++){
                    lotto[a] = a + 1;
                }

                for(int a = 0; a < 7; a++) {
                    int lottoNum = (int) (Math.random() * 45);
                    if (a != lottoNum) {
                        tmp = lotto[a];
                        lotto[a] = lotto[lottoNum];
                        lotto[lottoNum] = tmp;
                    }
                    Log.i("Button", lotto[a] + "");
                }

                num1.setText("숫자1: " + lotto[0] + "");
                num2.setText("숫자2: " + lotto[1] + "");
                num3.setText("숫자3: " + lotto[2] + "");
                num4.setText("숫자4: " + lotto[3] + "");
                num5.setText("숫자5: " + lotto[4] + "");
                num6.setText("숫자6: " + lotto[5] + "");
                bonus.setText("보너스숫자: " + lotto[6] + "");
            }
        });
        /*
        getNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 길이가 6인 ArrayList 생성
                List<Integer> lottonNums = new ArrayList<>();

                // 길이가 6이 될 때까지 반복
                while(lottoNums.size() < 6){
                    // Math.random() * 45 -> 0 ~ 44 범위
                    // Math.random() * 45 + 1 -> 1 ~ 45 범위
                    int get = (int)(Math.random() * 45) = 1;

                    // 기존에 선택된 번호가 중복되지 않는지 여부 확인
                    if(!lottoNums.contains(get)){
                        // 추가
                        lottoNums.add(get);
                    }
                }
                // 숫자 정렬
                Collextions.sort(lottoNums);

                int bonus = 0;
                while(bonus == 0 || lottoNums.contains(bonus){
                    bonus = (int)(Math.random() * 45) + 1;
                }
            }
        }
         */

    }
}









