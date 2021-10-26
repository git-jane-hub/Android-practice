package org.ict.widgetprj11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
// 액션바는 java코드로만 구현하기 때문에 acrtivity_main.xml 파일이 필요하지 않음
// MainActivity 에서는 탭을 구현하고 CustomTabFragment 클래스를 만들어 탭별 화면을 구현
// MainActivity는 AppCompatActivity 를 상속하고 ActionBar 를 구현
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    // Tap 개수만큼 변수 선언(3개)
    ActionBar.Tab tabKorean, tabChinese, tabJapanese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabKorean = bar.newTab();
        tabKorean.setText("한식");
        tabKorean.setTabListener(this);
        bar.addTab(tabKorean);

        tabChinese = bar.newTab();
        tabChinese.setText("중식");
        tabChinese.setTabListener(this);
        bar.addTab(tabChinese);

        tabJapanese = bar.newTab();
        tabJapanese.setText("일식");
        tabJapanese.setTabListener(this);
        bar.addTab(tabJapanese);
    }

    // 탭이 선택될 때마다 바뀌는 내용을 처리해야하므로 onTabSelected를 재정의
    // CustomTabFragment 3개를 선언
    CustomTabFragment customFrags [] = new CustomTabFragment[3];

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 위에서 선언한 CustomTabFragment를 초기화
        CustomTabFragment cFrag = null;

        // 탭이 선택되지 않았다면 새로 탭을 생성(선택된 탭을 getPosition()으로 얻어올 수 있음)
        if(customFrags[tab.getPosition()] == null){
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        }else{
            // 탭이 선택된 적인 있다면
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면을 해당 탭으로 교체
        ft.replace(android.R.id.content, cFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}