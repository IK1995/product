package com.example.haja4.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.view.MotionEvent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by haja4 on 2018/03/04.
 */
public class Hyouzi extends Activity {
    InputStream is = null;
    BufferedReader br = null;
    String text = "";
    String[] str =new String[2];
    element mo ;

    private int[] range = {100,500,200,800};//判定用の座標（x_1,x_2,y_1,y_2）画像を用いるやり方だと座標でしか判定できなさそうだったので

    public  Hyouzi() {//適当

    }

    public element number(int k) {//画像を切り替えるメソッド　k乱数
        try {
            is = this.getAssets().open("sample.txt");
            br = new BufferedReader(new InputStreamReader(is));
            for (int i = 0; i < 2; i++) {//i<2の2はtxtに書かれている問題数
                str[i] = br.readLine();//すべての問題をまず格納
            }
            String[] mm=str[k].split(".",0);//ここでシャッフルしていることになる
            mo.category=Integer.parseInt(str[0]);
            mo.start_x=Integer.parseInt(str[1]);
            mo.start_y=Integer.parseInt(str[2]);
            mo.end_x=Integer.parseInt(str[3]);
            mo.end_y=Integer.parseInt(str[4]);
            mo.qID=Integer.parseInt(str[5]);
            mo.aID = Integer.parseInt(str[6]);
        }catch(Exception e){
            str[k]="";
        }
        return mo;
    }

    public String Judge(int x,int y,element Q){//判定用のメソッド
        String judge = "不正解...";
        //boolean judge = false;
        if(Q.start_x<=x&&Q.end_x>=x&&Q.start_y<=y&&Q.end_y>=y){//x_1<=judge_x<=x_2かつy_1<=judge_y<=y_2ならば成功
                                                                //judge を　trueにして返す
            judge = "正解！"; //おかしなところなしの場合range[]をすべて０にしてifでその時のみ
        }                       //judgeをtrueにして返すのもあり
        return judge;
    }

}

