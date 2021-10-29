package org.ict.explitintentprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {

    TextView tv;
    Button cancelBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        tv = (TextView)findViewById(R.id.tv);
        cancelBtn = (Button)findViewById(R.id.cancelBtn);

        Intent intent = getIntent();
        String getData = intent.getStringExtra("test2");
        tv.setText(getData);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
