package org.ict.tablecalculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    //Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multi, divi;
    // 버튼 개수가 10개이므로 10개의 빈버튼 생성
    Button[] numBtns = new Button[10];
    // 숫자 버튼은 배열로 저장
    Integer[] numBtnIds = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};
    Button plus, minus, multi, divi;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        for(int i = 0; i < numBtnIds.length; i++){
            numBtns[i] = (Button)findViewById(numBtnIds[i]);
        }

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multi = (Button)findViewById(R.id.multi);
        divi = (Button)findViewById(R.id.divi);

        result = (TextView)findViewById(R.id.result);

        // 부품 배열에 대해서는 onClick() 이벤트까지 반복문으로
        for(int i = 0; i < numBtns.length; i++){
            // 상수를 선언해 이벤트를 정상적으로 발생
            final int index;
            index  = i;
            numBtns[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.d("Btn", numBtns[index].getText() + "");
                    // num1이 클릭된 상태
                    if(num1.isFocused()){
                        num1.setText(numBtns[index].getText());
                    }
                    // num2가 클릭된 상태
                    else if(num2.isFocused()){
                        num2.setText(numBtns[index].getText());
                    }
                }
            });
        }
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resultNum1 = Integer.parseInt(num1.getText() + "");
                int resultNum2 = Integer.parseInt(num2.getText() + "");
                int resultValue = resultNum1 + resultNum2;
                result.setText(resultValue + "");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resultNum1 = Integer.parseInt(num1.getText() + "");
                int resultNum2 = Integer.parseInt(num2.getText() + "");
                int resultValue = resultNum1 - resultNum2;
                result.setText(resultValue + "");
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resultNum1 = Integer.parseInt(num1.getText() + "");
                int resultNum2 = Integer.parseInt(num2.getText() + "");
                int resultValue = resultNum1 * resultNum2;
                result.setText(resultValue + "");
            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultNum1 = Integer.parseInt(num1.getText() + "");
                double resultNum2 = Integer.parseInt(num2.getText() + "");
                double resultValue = resultNum1 / resultNum2;
                result.setText(resultValue + "");
            }
        });
    }
}