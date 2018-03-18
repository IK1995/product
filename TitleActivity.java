package com.example.haja4.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.*;


public class TitleActivity extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listに値を入れる。この段階では昇順
       // for(int i = 0 ; i < 25 ; i++) {
         //   list.add(i);
        //}
        // シャッフルして、順番を変える
        //Collections.shuffle(list);

        Button RecordBut=findViewById(R.id.recordBut);
        RecordBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),RecordActivity.class);
                startActivity(intent);
            }
        });

        Button StartBut=findViewById(R.id.startBut);
        StartBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),MainActivity.class);
                //intent.putIntegerArrayListExtra("number", list);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onDestroy() {
        // TODO 自動生成されたメソッド・スタブ
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO 自動生成されたメソッド・スタブ
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO 自動生成されたメソッド・スタブ
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO 自動生成されたメソッド・スタブ
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO 自動生成されたメソッド・スタブ
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO 自動生成されたメソッド・スタブ
        super.onStop();
    }

}

