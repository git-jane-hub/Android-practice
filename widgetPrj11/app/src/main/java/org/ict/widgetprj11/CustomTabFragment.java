package org.ict.widgetprj11;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

// androidx.fragment.app.Fragment 를 상속
public class CustomTabFragment extends androidx.fragment.app.Fragment{

    // 탭 이름을 감지해 어떤 탭을 보여줘야 하는지(한식, 중식, 일식) 확인을 위한 변수 선언
    String tabName;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // 탭 이름 감지 관련 코드 세팅
        Bundle data = getArguments();
        tabName = data.getString("tabName");

    }

    // 화면이 변경될 때마다 처리할 로직 작성
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // java 코드에서 LinearLayout을 생성
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // baseLayout은 탭 하단의 실제로 바뀔 화면
        LinearLayout baseLayout = new LinearLayout(super.getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        // 이미지파일을 넣으려면
        ImageView img = new ImageView(super.getActivity());


        if (tabName == "한식") {
            img.setImageResource(R.drawable.koreanfood);
            baseLayout.addView(img);
        }
        if (tabName == "중식") {
            img.setImageResource(R.drawable.chinese);
            baseLayout.addView(img);
        }
        if (tabName == "일식") {
            img.setImageResource(R.drawable.japanesefood);
            baseLayout.addView(img);
        }



        return baseLayout;
    }
}















