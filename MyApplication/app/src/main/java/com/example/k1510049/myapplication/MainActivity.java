package com.example.haja4.myapplication;

import android.support.v7.app.AppCompatActivity;
//import android.app.Activity;
import android.os.Bundle;
import android.util.Log;    //追加します
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

//public class MainActivity extends Activity implements OnTouchListener{
public class MainActivity extends AppCompatActivity  implements OnTouchListener{
    private Hyouzi pop;//判定、その他のメソッドが入った関数
    private int mode;//モード（詐欺メール、フィッシングetcの状態のこと）
    private int i;//問題番号
    private FrameLayout frameLayout01;
    private ImageView target;//カーソル（ポインタ）

    private int targetLocalX;//カーソル（ポインタ）を動かしているときのX座標
    private int targetLocalY;//～～～を～～～ときのY座標
    private int screenX;////https://dev.classmethod.jp/smartphone/android/touch/を参考にした
    private int screenY;
    int judge_x;//判定用のボタンを押したときのカーソルの中心X座標
    int judge_y;//～～～～～カーソルのY座標

    boolean judge = false; //判定用　おかしなところなしの問題を作るなら配列になるかも

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pop= new Hyouzi();
        mode = 0;
        i=0;

        Button button = findViewById(R.id.button);//判定ボタン
        Button button2 = findViewById(R.id.button2);//モード変更ボタン（おそらく不要になるかも）

        ImageView image1 = new ImageView(this);//問題画像
        image1.setImageResource(pop.number(mode,i));//問題画像を表示する
        target = (ImageView)findViewById(R.id.ImagePoint);//IDを取得
        target.setOnTouchListener(this);//カーソル（ポインタをタッチしたときの挙動）下にある

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//判定用ボタンをクリック（タップ）したときの判定
                judge_x=target.getLeft()+target.getWidth()/2;
                judge_y=target.getTop()+target.getHeight()/2;
                judge=pop.Judge(judge_x,judge_y,i);//判定、合っていればtrueになりiが増える
                if(judge==true){
                    i++;
                }
                ImageView image1 = (ImageView)findViewById(R.id.ImageView);//画像の変更
                image1.setImageResource(pop.number(mode,i));//おそらくここで別のプロセス（画面遷移などはいるかも？）
                //((TextView)findViewById(R.id.Text)).setText("X:"+judge_x +"Y:"+judge_y);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mode++;
                ImageView image2 = (ImageView)findViewById(R.id.ImageView);
                image2.setImageResource(pop.number(mode,i));
            }
        });

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {//カーソル画像をタッチしたときの挙動

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://タッチしたときの挙動

                targetLocalX = target.getLeft();
                targetLocalY = target.getTop();

                screenX = x;
                screenY = y;

                break;

            case MotionEvent.ACTION_MOVE://動かしたとき（ドラッグ）の挙動

                int diffX = screenX - x;
                int diffY = screenY - y;

                targetLocalX -= diffX;
                targetLocalY -= diffY;

                target.layout(targetLocalX,
                        targetLocalY,
                        targetLocalX + target.getWidth(),
                        targetLocalY + target.getHeight());

                screenX = x;
                screenY = y;

                break;

            case MotionEvent.ACTION_UP://離した時の挙動,たぶんほとんど意味ないかも

                int targetCenter  = target.getLeft() + target.getWidth()/2;
                int targetHalf = target.getTop() + target.getHeight()/2;

                break;
        }
        return true;
    }
}
