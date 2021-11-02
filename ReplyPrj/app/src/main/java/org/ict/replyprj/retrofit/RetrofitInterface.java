package org.ict.replyprj.retrofit;

import org.ict.replyprj.vo.Example;
import org.ict.replyprj.vo.ReplyList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("http://10.0.2.2:8181/replies/all/{bno}")
    Call<String> getReply(@Query("bno") String bno);
}
