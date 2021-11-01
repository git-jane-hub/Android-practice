package org.ict.listviewprj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    ImageView city;
    Button goback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        city = (ImageView)findViewById(R.id.city);
        goback = (Button)findViewById(R.id.goback);

        Intent intent = getIntent();
        String cityImg = intent.getStringExtra("city");
        Log.d("check: ", cityImg);

        int img = getResources().getIdentifier(cityImg, "drawable", this.getPackageName());
        city.setImageResource(img);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
