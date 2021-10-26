package org.ict.widgetprj10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

// 작성하지 않아도 작동하지만 TabHost는 업데이트가 중지된 위젯이기 때문에 콘솔에 경고가 나타날 수 있음
@SuppressWarnings("deprecation")
// TabHost는 상속도 TabActivity를 받음
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabHost 변수에 XML에서 생성한 TabHost를 가져옴
        // XML파일에 설정한 TabHost의 id가 tabhost로 고정되어있기 때문에 아래처럼 getter로 가져올 수 있음
        TabHost tabHost = getTabHost();

        // 위쪽 Tab 메뉴에 들어갈 메뉴명을 작성
        // newTabSpec에는 호출 명칭, setIndicator 에는 화면에 보여줄 명칭 작성
        TabHost.TabSpec tsk = tabHost.newTabSpec("KoreanFood").setIndicator("한식");

        // 1번 탭
        tsk.setContent(R.id.t1);
        // TabHost에 위에서 추가한 메뉴바 하나를 추가
        tabHost.addTab(tsk);

        TabHost.TabSpec tsc = tabHost.newTabSpec("ChineseFood").setIndicator("중식");
        tsc.setContent(R.id.t1);
        tabHost.addTab(tsc);

        TabHost.TabSpec tsm = tabHost.newTabSpec("MexicanFood").setIndicator("멕시칸푸드");
        tsm.setContent(R.id.t1);
        tabHost.addTab(tsm);

        //th.setCurrentTab(0);
    }
}