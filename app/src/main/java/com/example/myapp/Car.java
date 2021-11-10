package com.example.myapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Car extends baseObject{

    private ArrayList<Bitmap> arrBms = new ArrayList<>();
    private int count, vFlap, idCurrentBitmap;
    public Car(){
        this.count = 0;
        this.vFlap = 5;
        this.idCurrentBitmap = 0;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(this.getBm(), this.x, this.y, null);

    }

    public ArrayList<Bitmap> getArrBms() {
        return arrBms;
    }

    public void setArrBms(ArrayList<Bitmap> arrBms) {
        this.arrBms = arrBms;
        for (int i=0; i< arrBms.size(); i++){
            this.arrBms.set(i, Bitmap.createScaledBitmap(this.arrBms.get(i), this.width, this.height, true ));
        }
    }

    @Override
    public Bitmap getBm() {
        count++;
        if(this.count == this.vFlap){
            for(int i=0; i<arrBms.size();i++){
                if(i == arrBms.size()-1){
                    this.idCurrentBitmap = 0;
                    break;
                }else if(this.idCurrentBitmap == i){
                    idCurrentBitmap = i+1;
                    break;
                }
            }
            count = 0;
        }
        return this.arrBms.get(idCurrentBitmap);
    }
}
