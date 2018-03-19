package com.example.haja4.myapplication;

/**
 * Created by teppei on 2018/03/13.
 */

public class element {
    int category =0;
    int start_x;
    int start_y;
    int end_x;
    int end_y;
    String qID;
    String aID;
    public void element(){
    }
    public element(int c, int x1,int y1,int x2,int y2,String q,String a){
        this.category = c;
        this.start_x=x1;
        this.start_y=y1;
        this.end_x=x2;
        this.end_y=y2;
        this.qID=q;
        this.aID=a;
    }
}
/*
elementに問題の答えを入れていく
 */
