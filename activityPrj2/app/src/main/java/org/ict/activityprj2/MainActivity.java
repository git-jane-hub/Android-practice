package org.ict.activityprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button movetoSub1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movetoSub1 = (Button)findViewById(R.id.movetoSub1);

        movetoSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent로 sub1로 넘어가도록 설정
                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);
                startActivity(intent);
            }
        });
    }
}