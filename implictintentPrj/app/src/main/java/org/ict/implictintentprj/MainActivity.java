package org.ict.implictintentprj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button call, openWeb, openGoogle, google, message, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = (Button)findViewById(R.id.call);
        openWeb = (Button)findViewById(R.id.openWeb);
        openGoogle = (Button)findViewById(R.id.openGoogle);
        google = (Button)findViewById(R.id.google);
        message = (Button)findViewById(R.id.message);
        photo = (Button)findViewById(R.id.photo);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 암시적인텐트 - 보내거나 받은 데이터가 없는데 전달되는 것
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                // 보낸 적이 없는 전화번호가 같이 전달
                startActivity(intent);
            }
        });
        openWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        openGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/maps/place/%ED%95%9C%EA%B5%ADICT%EC%9D%B8%EC%9E%AC%EA%B0%9C%EB%B0%9C%EC%9B%90/@37.5548129,126.918354,17z/data=!3m1!4b1!4m5!3m4!1s0x357c99b56609aa51:0xa1bd0b6d813b1eda!8m2!3d37.5548129!4d126.9205427");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "android");
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요 :)");
                intent.setData(Uri.parse("smsto: " + Uri.encode("010-1234-5678")));
                startActivity(intent);
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }
}