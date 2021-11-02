package org.ict.movieprj.retrofit;

import android.os.PersistableBundle;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //필요 변수들을 선언
    private static RetrofitClient instance = null;
    private static RetrofitInterface retrofitInterface;
    // baseUrl만 상황에 맞춰 변경
    private static String baseUrl = "http://www.kobis.or.kr";

    // 싱글턴 패턴으로 RetrofitClient 생성 및 활용
    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                // baseUrl에는 or.kr이나 .com으로 끝나는 주소만 기입
                .baseUrl(baseUrl)
                // 받아온 데이터를 json에서 자바에 맞게 변환
                .addConverterFactory(GsonConverterFactory.create())
                // 변환된 데이터 저장
                .build();
        // RetrofitInterface 구현
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitClient getInstance(){
       if(instance == null){
           instance = new RetrofitClient();
       }
       return instance;
    }

    public static RetrofitInterface getRetrofitInterface(){
        return retrofitInterface;
    }
}
