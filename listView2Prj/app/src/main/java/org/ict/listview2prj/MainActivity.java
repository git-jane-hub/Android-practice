package org.ict.listview2prj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.et);
        btn = (Button)findViewById(R.id.btn);
        lv = (ListView)findViewById(R.id.lv);

        // List 생성
        // List로는 배열([])과 ArrayList가 올 수 있는데 가변적으로 변동을 주기 위해서는 ArrayList가 옴
        final ArrayList<String> trips = new ArrayList<String>();

        // 위의 목록을 토대로 데이터가 들어갈 Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trips);

        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // btn 클릭하면 et에 있던 요소를 ArrayList에 .add로 삽입
                trips.add(et.getText() + "");

                // adapter에 추가된 리스트로 갱신 반영
                adapter.notifyDataSetChanged();
                et.setText("");
            }
        });

        // 요소를 길게 클릭하면 삭제되도록 처리
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                trips.remove(position);
                // 반영
                adapter.notifyDataSetChanged();
                Log.d("check", position + "");
                return false;
            }
        });
    }
}