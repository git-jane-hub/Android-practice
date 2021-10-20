package org.ict.changeimageprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView showApp, showAnimal;
    CheckBox check;
    // radioGroup도 만들어줌
    RadioGroup radioGroup;
    RadioButton tigerBtn, lionBtn;
    Button pressBtn;
    ImageView lionImg, tigerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showApp = (TextView)findViewById(R.id.showApp);
        showAnimal = (TextView)findViewById(R.id.showAnimal);
        check = (CheckBox)findViewById(R.id.check);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        tigerBtn = (RadioButton)findViewById(R.id.tigerBtn);
        lionBtn = (RadioButton)findViewById(R.id.lionBtn);
        pressBtn = (Button)findViewById(R.id.pressBtn);
        lionImg = (ImageView)findViewById(R.id.lionImg);
        tigerImg = (ImageView)findViewById(R.id.tigerImg);

        // 체크박스 클릭을 감지
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.d("Checkbox", "clicked!!!!!!!!!!!!!");
                Log.d("Checkbox", isChecked + "");
                // check == true
                if(isChecked){
                    // invisible 요소들 중 ImageView를 제외한 컨텐츠가 보이도록 전환
                    showAnimal.setVisibility(View.VISIBLE);
                    // radioGroup 자체가 보이도록 해야함
                    radioGroup.setVisibility(View.VISIBLE);
                    pressBtn.setVisibility(View.VISIBLE);
                }
                // check == false
                else{
                    // if문에서 보이도록 전환된 컨텐츠를 다시 보이지 않도록 전환
                    showAnimal.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    pressBtn.setVisibility(View.INVISIBLE);
                    lionImg.setVisibility(View.INVISIBLE);
                    tigerImg.setVisibility(View.INVISIBLE);

                    // 체크박스의 체크를 해제하고 다시 체크하면 라디오버튼이 선택되어있으므로 해제시킴
                    radioGroup.clearCheck();
                    // 혹은 개별 체크버튼 해제
                    //lionBtn.setChecked(false);
                    //tigerBtn.setChecked(false);
                }
            }
        });

        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checkbox에 어떤 요소가 선택되었는지 확인
                int checked = radioGroup.getCheckedRadioButtonId();
                // 디버깅을 통해 radioGroup의 아이디를 가져오기 - Log를 확인하지 않으면 알 수 없음
                // lionBtn: 2131230949
                // tigerBtn: 2131231155
                Log.d("radioBtn", checked + "");

                if (checked == 2131230949) {
                    lionImg.setVisibility(View.VISIBLE);
                    tigerImg.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "사자 선택", Toast.LENGTH_SHORT).show();
                } else if(checked == 2131231155){
                    tigerImg.setVisibility(View.VISIBLE);
                    lionImg.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "호랑이 선택", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





