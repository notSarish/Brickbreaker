package com.example.brickbreaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


public class DrawView2 extends View {
    private Paint paint = new Paint();
    private Bricks[][] rectss;

    public DrawView2(Context context, Bricks[][] rects) {
        super(context);
        int color;
        for (int i = 0; i < rects.length; i++) {
            for (int j = 0; j < rects[i].length; j++) {
                if (rects[i][j] == null) {
                    color = 0;
                } else {
                    color = rects[i][j].getColor();
                }
                rects[i][j] = new Bricks(new Rect(270*j, i*175 , 270*(j+1), (i + 1)*175), color);
            }
        }
        rectss = rects;

    }
    public Bricks[][] getRectss() {
        return rectss;
    }
    //right: 1080
    //height is 1794
    @Override
    public void onDraw(Canvas canvas) {
        for (int i = 0; i < rectss.length; i++) {
            for (int j = 0; j < rectss[i].length; j++) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.WHITE);
                if (rectss[i][j].getColor() == 0) {
                    paint.setColor(Color.rgb(247, 247, 247));
                    //223 227 238
                    //139 157 195
                    //59 89 152
                } else if (rectss[i][j].getColor() == 1) {
                    paint.setColor(Color.rgb(223, 227, 238));
                } else if (rectss[i][j].getColor() == 2) {
                    paint.setColor(Color.rgb(139, 157, 195));
                } else {
                    paint.setColor(Color.rgb(59,89,152));
                }
                canvas.drawRect(rectss[i][j].getRect(), paint);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                canvas.drawRect(rectss[i][j].getRect(), paint);
               /* paint.setTextSize(35);
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawText(valueOf(rectss[i][j].getColor()), 270*j + 135, 175*i + 88 , paint);
*/
            }
        }



    }

}

