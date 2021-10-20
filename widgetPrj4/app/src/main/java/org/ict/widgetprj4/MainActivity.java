package org.ict.widgetprj4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView operation, result1, result2;
    Button plus, minus, multiply, division, equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연산할 숫자
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        // 연산 기호
        operation = (TextView)findViewById(R.id.operation);

        // 연산
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        division = (Button)findViewById(R.id.division);

        equal = (Button)findViewById(R.id.equal);

        // 연산 결과값
        result1 = (TextView)findViewById(R.id.result1);
        result2 = (TextView)findViewById(R.id.result2);

        // 더하기
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String numPlus1 = num1.getText().toString();
                result1.setText(numPlus1 + "    +");
            }
        });

        // 빼기
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String numPlus1 = num1.getText().toString();
                result1.setText(numPlus1 + "    -");
            }
        });

        // 곱하기
        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String numPlus1 = num1.getText().toString();
                result1.setText(numPlus1 + "    *");
            }
        });

        // 나누기
        division.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String numPlus1 = num1.getText().toString();
                result1.setText(numPlus1 + "    /");
            }
        });

        // 결과
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstResult = result1.getText().toString();
                String numPlus1 = num1.getText().toString();
                String numPlus2 = num2.getText().toString();
                if(firstResult.contains("+")) {
                    int plusNum = Integer.parseInt(numPlus1) + Integer.parseInt(numPlus2);
                    result2.setText(numPlus2 + " =    " + plusNum);
                }else if(firstResult.contains("-")){
                    int plusNum = Integer.parseInt(numPlus1) - Integer.parseInt(numPlus2);
                    result2.setText(numPlus2 + " =    " + plusNum);
                }else if(firstResult.contains("*")){
                    int plusNum = Integer.parseInt(numPlus1) * Integer.parseInt(numPlus2);
                    result2.setText(numPlus2 + " =    " + plusNum);
                }else if(firstResult.contains("/")){
                    int plusNum = Integer.parseInt(numPlus1) / Integer.parseInt(numPlus2);
                    result2.setText(numPlus2 + " =    " + plusNum);
                }
                num1.setText("");
                num2.setText("");
            }
        });
/*
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "더하기", Toast.LENGTH_SHORT).show();

                // 먼저 문자로 변수작성
                String numPlus1 = num1.getText().toString();
                String numPlus2 = num2.getText().toString();

                // 문자로 가져온 값 숫자로 변경
                int plusNum = Integer.parseInt(numPlus1) + Integer.parseInt(numPlus2);
                // 숫자인 결과값을 문자로 변경
                result.setText(plusNum + "");

                operation.setText(" + ");

                num1.setText("");
                num2.setText("");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "빼기", Toast.LENGTH_SHORT).show();
                String numMinus1 = num1.getText().toString();
                String numMinus2 = num2.getText().toString();

                int minusNum = Integer.parseInt(numMinus1) - Integer.parseInt(numMinus2);

                result.setText(minusNum + "");

                operation.setText(" - ");
                num1.setText("");
                num2.setText("");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "곱하기", Toast.LENGTH_SHORT).show();

                String numMulti1 = num1.getText().toString();
                String numMulti2 = num2.getText().toString();

                int multiNum = Integer.parseInt(numMulti1) * Integer.parseInt(numMulti2);

                result.setText(multiNum + "");

                operation.setText(" * ");
                num1.setText("");
                num2.setText("");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "나누기", Toast.LENGTH_SHORT).show();

                String numDiv1 = num1.getText().toString();
                String numDiv2 = num2.getText().toString();

                int divNum = Integer.parseInt(numDiv1) / Integer.parseInt(numDiv2);

                result.setText(divNum + "");

                operation.setText(" / ");
                num1.setText("");
                num2.setText("");
            }
        });
        */
    }
}