package org.ict.replyprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.ict.replyprj.retrofit.ReplyAdapter;
import org.ict.replyprj.retrofit.RetrofitClient;
import org.ict.replyprj.retrofit.RetrofitInterface;
import org.ict.replyprj.vo.Example;
import org.ict.replyprj.vo.ReplyList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    RecyclerView recyclerView;
    RecyclerView.Adapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        retrofitInterface.getReply("10791").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //List<Example> result = (List<Example>) response.body();
                Log.d("테스트", response.toString());
                //rAdapter = new ReplyAdapter((List<Example>) result);
                //recyclerView.setAdapter(rAdapter);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("받아온 데이터 체크: ", "실패했습니다.");
            }
        });
    }
}