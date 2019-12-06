package com.example.brickbreaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;

public class DrawView extends View {
    private Paint paint0 = new Paint();
    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private Paint paint3 = new Paint();
    private Rect rect0 = new Rect(0, 0, 1500, 175);
    private Rect rect = new Rect(0, 200, 1500, 350);
    private Rect rect2 = new Rect(0, 375, 1500, 525);
    private Rect rect3 = new Rect(0,550, 1500, 700);
    public DrawView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        //title
        paint0.setStyle(Paint.Style.FILL);
        paint0.setColor(Color.BLUE);
        canvas.drawRect(rect0, paint0);
        //paint0.setStyle(Paint.Style.STROKE);
        //paint0.setColor(Color.BLACK);
        //canvas.drawRect(rect, paint0);
        paint0.setTextSize(60);
        paint0.setColor(Color.WHITE);
        paint0.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Brick Breaker", 347, 115, paint0);


        //first button
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(rect, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);
        paint.setTextSize(55);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Play Normal Mode", 300, 300, paint);

        //second button
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.WHITE);
        canvas.drawRect(rect2, paint2);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.BLACK);
        canvas.drawRect(rect2, paint2);
        paint2.setTextSize(55);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Play Your Own Design", 265, 475, paint2);

        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(Color.WHITE);
        canvas.drawRect(rect3, paint3);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(Color.BLACK);
        canvas.drawRect(rect3, paint3);
        paint3.setTextSize(55);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Make Your Own Design", 255, 650, paint3);


    }

}
