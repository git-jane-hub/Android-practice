package org.ict.widgetprj8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView acv;
    MultiAutoCompleteTextView macv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acv = (AutoCompleteTextView)findViewById(R.id.acv);
        macv = (MultiAutoCompleteTextView)findViewById(R.id.macv);

        // 검색창에 띄울 아이템 나열
        String [] items = {"아메리카노", "큐브라떼", "모히또", "카모마일", "레몬티"};

        // 부품과 데이터를 연결하기 위해 어댑터라는 개념을 사용
        // 파라미터 this와 simple_dropdown_item_1line은 고정, items를 넣어야하는 데이터에 맞춰 작성
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        // setAdapter() 기능을 이용해 ArrayAdapter와 부품 연결
        acv.setAdapter(adp);

        // macv에도 연결
        // String 배열 내부 자료들을 쉼표로 하나씩 구분해 인식할 수 있도록 토크나이저를 같이 세팅해줘야함
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        macv.setTokenizer(token);
        // 토크나이징을 통해 쉼표로 자료들을 구분하고 어댑터와 연결
        macv.setAdapter(adp);
    }
}