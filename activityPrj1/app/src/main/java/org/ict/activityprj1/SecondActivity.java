package org.ict.activityprj1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends Activity {

    Button prev;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        prev = (Button)findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 해당 창 아래 해당 창으로 넘어오기 전 창이있으므로 해당 창을 종료하면 이전 창으로 갈 수 있음
                // finish()가 실행되면 해당 창이 없어짐
                finish();
            }
        });
    }
}
