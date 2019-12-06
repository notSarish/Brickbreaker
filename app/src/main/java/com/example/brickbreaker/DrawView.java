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
    private Paint paint = new Paint();
    private Rect rect = new Rect(0, 200, 1500, 350);
    public DrawView(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        //paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(rect, paint);

        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);

        paint.setTextSize(55);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("Play Normal Mode", 300, 300, paint);

    }

}
