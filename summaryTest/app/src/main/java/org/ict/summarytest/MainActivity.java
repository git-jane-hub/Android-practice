package org.ict.summarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox check;
    TextView spot;
    RadioGroup trip;
    RadioButton newyork, taiwan, bali, bankok, sydney;
    Button btn;
    ImageView newyorkImg, taiwanImg, baliImg, bankokImg, sydneyImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (CheckBox)findViewById(R.id.check);
        spot = (TextView)findViewById(R.id.spot);
        trip = (RadioGroup)findViewById(R.id.trip);
        newyork = (RadioButton)findViewById(R.id.newyork);
        taiwan = (RadioButton)findViewById(R.id.taiwan);
        bali = (RadioButton)findViewById(R.id.bali);
        bankok = (RadioButton)findViewById(R.id.bankok);
        sydney = (RadioButton)findViewById(R.id.sydney);
        btn = (Button)findViewById(R.id.btn);
        newyorkImg = (ImageView)findViewById(R.id.newyorkImg);
        taiwanImg = (ImageView)findViewById(R.id.taiwanImg);
        baliImg = (ImageView)findViewById(R.id.baliImg);
        bankokImg = (ImageView)findViewById(R.id.bankokImg);
        sydneyImg = (ImageView)findViewById(R.id.sydneyImg);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    spot.setVisibility(View.VISIBLE);
                    trip.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }else{
                    spot.setVisibility(View.INVISIBLE);
                    trip.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}