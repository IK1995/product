package com.example.haja4.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
/**
 * Created by k1510049 on 2018/03/11.
 */

public class result_pic extends AppCompatActivity {
    String str;
    private int roop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_pic);

        intent = getIntent();

        str = intent.getStringExtra("JUDGE");//正解or不正解
        roop = intent.getIntExtra("Number",0);//前の画面で言うi
        //ここに解説用画像を表示するアレを書く予定
        roop++;//一応ここで増やしておく
        ((TextView)findViewById(R.id.Answer)).setText(str);

        Button button = findViewById(R.id.button);//判定ボタン

       button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {//判定用ボタンをクリック（タップ）したときの判定
                if(roop<10){//10以下なら前の画面に、以上ならお疲れ様画面に
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    intent.putExtra("nuMber",roop);
                    //startActivity(intent);
                    setResult(RESULT_OK, intent);
                    finish();//一応
                }
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
