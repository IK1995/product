package com.example.haja4.myapplication;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
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
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by haja4 on 2018/03/04.
 */
public class Hyouzi extends Activity {

    element mo ;
    element ee ;
    int mm[] = new int[5];
    String[] ss = new String[2];

    private int[] range = {100,500,200,800};//判定用の座標（x_1,x_2,y_1,y_2）画像を用いるやり方だと座標でしか判定できなさそうだったので

    public  Hyouzi() {//適当

    }

    public element number(String str) {//画像を切り替えるメソッド　k乱数

            String[] nn=str.split(" ");//ここでシャッフルしていることになる
        for(int i=0;i<5;i++){
            mm[i]=Integer.parseInt(nn[i]);
        }
        ss[0]=nn[5];
        ss[1]=nn[6];
            mo = new element(mm[0],mm[1],mm[2],mm[3],mm[4],ss[0],ss[1]);
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

