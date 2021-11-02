package org.ict.movieprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.ict.movieprj.retrofit.MovieAdapter;
import org.ict.movieprj.retrofit.RetrofitClient;
import org.ict.movieprj.retrofit.RetrofitInterface;
import org.ict.movieprj.vo.BoxOfficeResult;
import org.ict.movieprj.vo.DailyBoxOffice;
import org.ict.movieprj.vo.Example;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 비동기 요청을 담당하는 Retrofit관련 변수 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 비동기 요청 확인용 버튼
    //Button asyncBtn;

    RecyclerView recyView;
    // RecyclerAdapter 필요
    RecyclerView.Adapter mAdapter;

    // 상수로 본인 key 값을 저장
    final String KEY = "719e001883f1d73978165c646eb736a7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asyncBtn = (Button)findViewById(R.id.asyncBtn);


        // Retrofit 요소들을 연결
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        // RecyclerView 요소를 먼저 연결
        recyView = (RecyclerView)findViewById(R.id.recyView);
        // RecyclerView 는 레이아웃 설정을 자바에서 받아야 표현됨
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyView.setLayoutManager(layoutManager);

        // 화면이 켜졌을 때 비동기 요청으로 데이터를 받아오고, 해당 데이터를 RecyclerView 내부에 세팅하도록 처리
        retrofitInterface.getBoxOffice(KEY, "20211101").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                // 비동기 데이터 저장
                Example result = response.body();
                // result 내부의 영화정보를 얻어 MovieAdapter 생성자에 전달
                mAdapter = new MovieAdapter(result.getBoxOfficeResult().getDailyBoxOfficeList());
                // RecyclerView에 MovieAdapter를 전달해서 cardView 양식으로 반복하도록 처리
                recyView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("받아온 데이터 체크: ", "실패했습니다.");
            }
        });

        /* 버튼을 눌러 요청했을 때 데이터를 가져오는지 확인
        asyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 요청에 따른 결과(성공, 실패)
                retrofitInterface.getBoxOffice(KEY, "20210826").enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Example result = response.body();
                        Log.d("받아온 데이터 체크: ", result.getBoxOfficeResult() + "");

                        for(DailyBoxOffice d : result.getBoxOfficeResult().getDailyBoxOfficeList()){
                            Log.d("영화 제목: ", d.getMovieNm() + "(" + d.getAudiCnt() + "/" + d.getScrnCnt() + ")");
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d("받아온 데이터 체크: ", "실패했습니다.");
                    }
                });
            }
        });
        */
    }
}