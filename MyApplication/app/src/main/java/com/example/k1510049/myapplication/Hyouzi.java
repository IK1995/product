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


/**
 * Created by haja4 on 2018/03/04.
 */
public class Hyouzi extends Activity {

    private int[] range = {100,500,200,800};//判定用の座標（x_1,x_2,y_1,y_2）画像を用いるやり方だと座標でしか判定できなさそうだったので

    public Hyouzi() {//適当

    }

    public int number(int m, int k) {//画像を切り替えるメソッド　mはモード、iは問題番号
        int[][] Id = {{R.drawable.mario, R.drawable.charac},
                {R.drawable.ppppp, R.drawable.suzukiface}};//画像を収容するint配列　IDのためintらしいです
                                                            //紫？drawable.～～の「～～」が画像ファイル名です(pngとかはいらない)
        return Id[m][k];
    }

    public boolean Judge(int x,int y,int i){//判定用のメソッド
        boolean judge = false;
        if(range[0]<=x&&range[1]>=x&&range[2]<=y&&range[3]>=y){//x_1<=judge_x<=x_2かつy_1<=judge_y<=y_2ならば成功
                                                                //judge を　trueにして返す
            judge = true; //おかしなところなしの場合range[]をすべて０にしてifでその時のみ
        }                       //judgeをtrueにして返すのもあり
        return judge;
    }

}

