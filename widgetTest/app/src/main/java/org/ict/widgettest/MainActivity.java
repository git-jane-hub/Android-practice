package org.ict.widgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("Button", "버튼이 클릭됨");
                Toast.makeText(getApplicationContext(), "버튼을 클릭하셨네요.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}