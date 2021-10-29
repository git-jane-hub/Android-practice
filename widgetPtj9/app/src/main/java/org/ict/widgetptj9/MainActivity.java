package org.ict.widgetptj9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button prev, next;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // ViewFlipper는 final로 선언해야함
        //final ViewFlipper vf;

        prev = (Button)findViewById(R.id.prev);
        next = (Button)findViewById(R.id.next);
        vf = (ViewFlipper)findViewById(R.id.vf);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showPrevious();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vf.showNext();
            }
        });
    }
}