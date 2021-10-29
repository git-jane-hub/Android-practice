package org.ict.contextmenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Button backBtn;//, statusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        backBtn = (Button) findViewById(R.id.backBtn);
        //statusBtn = (Button) findViewById(R.id.statusBtn);
        // 버튼을 클릭하면 contextmenu가 열리도록 연결
        registerForContextMenu(backBtn);
        //registerForContextMenu(statusBtn);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        Log.d("tag", v + "");

        // 버튼 길게 눌러야됨
        if (v == backBtn) {
            // backBtn에는 menu1.xml을 연결
            menuInflater.inflate(R.menu.menu1, menu);
        }
        /*
        if (v == statusBtn) {
            menuInflater.inflate(R.menu.menu2, menu);
        }
        */


    }
    Integer rotate = 0;
    Integer size = 0;
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Log.d("selected", item.getItemId() + "");
        if(item.getItemId() == R.id.backRed){
            layout.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == R.id.backBlue){
            layout.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId() == R.id.backYellow){
            layout.setBackgroundColor(Color.YELLOW);
        }else if(item.getItemId() == R.id.backGreen){
            layout.setBackgroundColor(Color.GREEN);
        }
        /*
        else if(item.getItemId() == R.id.rotate){
            layout.setBackgroundColor(Color.WHITE);
            rotate += 45;
            statusBtn.setRotation(rotate);
        }else if(item.getItemId() == R.id.upSize){
            layout.setBackgroundColor(Color.WHITE);
            size += 2;
            statusBtn.setScaleX(size);
            statusBtn.setScaleY(size);
            if(size == 10 | size){
                statusBtn.setScaleX(1);
                statusBtn.setScaleY(1);
            }
        }
         */
        return super.onContextItemSelected(item);
    }

}









