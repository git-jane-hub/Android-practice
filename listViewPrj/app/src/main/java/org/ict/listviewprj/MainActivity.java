package org.ict.listviewprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);

        // ListView에 적용할 목록
        final String[] trips = {"newyork", "sydney", "shanghai", "taiwan", "hongkong", "bankok", "bali", "singapore", "cancun", "hanoi",
                                "beijing", "tokyo", "la", "hawaii", "habana"};

        // ListView는 AdapterView를 상속해 만들어짐
        // 파라미터로 출력될 xml화면(this로 작성하면 자동으로 setContentView에서 설정한 파일로 지정), 스타일, 출력자료
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trips);
        // lv에 adapter 내용을 적용
        lv.setAdapter(adapter);

        // 위임식 클릭이벤트 처리
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("parent: ", parent + "");
                Log.d("view: ", view + "");
                Log.d("position: ", position + "");
                Log.d("id: ", id + "");

                // index를 이용해 클릭하면 Toast로 클릭한 도시명이 나타나도록
                Toast.makeText(MainActivity.this, "move to " + trips[position] + "", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("city", trips[position] + "");
                startActivity(intent);
            }
        });
    }
}