package org.ict.changimgprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showAni;
    Switch showApp;
    RadioGroup animal;
    RadioButton lion, tiger;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAni = (TextView)findViewById(R.id.showAni);
        showApp = (Switch)findViewById(R.id.showApp);
        animal = (RadioGroup)findViewById(R.id.animal);
        lion = (RadioButton)findViewById(R.id.lion);
        tiger = (RadioButton)findViewById(R.id.tiger);
        img = (ImageView)findViewById(R.id.img);

        showApp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // switch가 on이라면
                if(isChecked){
                    showAni.setVisibility(View.VISIBLE);
                    animal.setVisibility(View.VISIBLE);
                }else{
                    showAni.setVisibility(View.INVISIBLE);
                    animal.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    animal.clearCheck();
                }
            }
        });

        // onCheck 이벤트
        lion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.i("lion", "checked!!!!!!!");
                if(isChecked) {
                    img.setImageResource(R.drawable.lion);
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
        tiger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    img.setImageResource(R.drawable.tiger);
                    img.setVisibility(View.VISIBLE);

                }
            }
        });
        /*
        // onClick 이벤트
        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.lion);
                img.setVisibility(View.VISIBLE);
            }
        });
        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.tiger);
                img.setVisibility(View.VISIBLE);
            }
        });
         */
    }
}