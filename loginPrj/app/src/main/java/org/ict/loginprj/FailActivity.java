package org.ict.loginprj;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FailActivity extends AppCompatActivity {

    TextView tv;
    Button backtoLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        tv = (TextView)findViewById(R.id.tv);
        backtoLogin = (Button)findViewById(R.id.backtoLogin);

        Intent intent = getIntent();
        String getResult = intent.getStringExtra("result");
        Log.d("result: ", getResult + "");
        tv.setText(getResult);

        backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
