package org.ict.tripviewprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv = (TextView)findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        iv = (ImageView)findViewById(R.id.iv);

        int [] countryNums = {R.drawable.con0, R.drawable.con1, R.drawable.con2, R.drawable.con3,
                R.drawable.con4, R.drawable.con5, R.drawable.con6, R.drawable.con7, R.drawable.con8,
                R.drawable.con9, R.drawable.con10, R.drawable.con11, R.drawable.con12, R.drawable.con13,
                R.drawable.con14,};
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("cityName");
        int position = intent.getIntExtra("position", 0);
        iv.setImageResource(countryNums[position]);
        tv.setText(cityName);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
