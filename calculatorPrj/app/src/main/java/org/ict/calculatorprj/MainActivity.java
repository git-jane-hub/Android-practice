package org.ict.calculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 이거 미완성
    TextView result;
    Button one, two, three, four, five, six, seven, eight, nine;
    Button ac, plus, minus, multiply, division, equal;

    Integer firstNum;
    Integer secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        ac = (Button)findViewById(R.id.ac);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        division = (Button)findViewById(R.id.division);
        equal = (Button)findViewById(R.id.equal);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!result.getText().toString().contains(" ")){
                    firstNum = 1;
                    result.setText(firstNum + "");
                }else{
                    secondNum = 1;
                    result.setText(firstNum + " + " + secondNum);
                }
            }
        });


        // 연산
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(firstNum + " + ");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(firstNum + " - ");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(firstNum + " * ");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(firstNum + " / ");
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                firstNum = 0;
                secondNum = 0;
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int resultNum;
                if(result.toString().contains("+")){
                    resultNum = firstNum + secondNum;
                    result.setText(firstNum + " + " + secondNum + " = " + resultNum);
                }else if(result.toString().contains("-")){
                    resultNum = firstNum - secondNum;
                    result.setText(firstNum + " - " + secondNum + " = " + resultNum);
                }else if(result.toString().contains("*")){
                    resultNum = firstNum * secondNum;
                    result.setText(firstNum + " * " + secondNum + " = " + resultNum);
                }else if(result.toString().contains("/")){
                    resultNum = firstNum / secondNum;
                    result.setText(firstNum + " / " + secondNum + " = " +  resultNum);
                }
            }
        });
    }
}