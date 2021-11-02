package org.ict.movieprj.retrofit;

import org.ict.movieprj.vo.Example;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// RetrofitInterface에는 비동기 호출에 대한 가변 파라미터 고정주소, 호출 형식 정의(어떤 주소와 어떤 방식으로 접근할지에 대한 정의)
// 가변파라미터: key값과 targetDt
public interface RetrofitInterface {

    // 영진위 API 서버는 조회권한만 가지고 있기 때문에 @GET("요청주소") 형식으로 작성
    @GET("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    // 요청에 대한 응답은 Call<Result>를 반환하는 Getter를 이용
    // 가변파라미터(현 사이트에서는 key, targetDt)는 @Query("파라미터명")자료변수형으로 지정
    Call<Example> getBoxOffice(@Query("key")String key, @Query("targetDt")String targetDt);
}
