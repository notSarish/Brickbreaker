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
    private Paint paint0 = new Paint();
    private Canvas canvass = new Canvas();
    private boolean condition;// = true;
    public DrawView2(Context context, Bricks[][] rects, Boolean set) {
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
        condition = set;
    }
    public Bricks[][] getRectss() {
        return rectss;
    }
    //right: 1080
    //height is 1794
    @Override
    public void onDraw(Canvas canvas) {
        if (condition) {
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

            paint0.setStyle(Paint.Style.FILL);
            paint0.setColor(Color.BLUE);
            canvas.drawRect(new Rect(0, 1400, 1080, 1794), paint0);
            //paint0.setStyle(Paint.Style.STROKE);
            //paint0.setColor(Color.BLACK);
            //canvas.drawRect(rect, paint0);
            paint0.setTextSize(60);
            paint0.setColor(Color.WHITE);
            paint0.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawText("Save Level and Exit", 300, 1650, paint0);

        } else {
            Paint paint0 = new Paint();
            Paint paint = new Paint();
            Paint paint2 = new Paint();
            Paint paint3 = new Paint();
            Rect rect0 = new Rect(0, 0, 1500, 175);
            Rect rect = new Rect(0, 200, 1500, 350);
            Rect rect2 = new Rect(0, 375, 1500, 525);
            Rect rect3 = new Rect(0,550, 1500, 700);
            paint0.setStyle(Paint.Style.FILL);
            paint0.setColor(Color.BLUE);
            canvass.drawRect(rect0, paint0);
            //paint0.setStyle(Paint.Style.STROKE);
            //paint0.setColor(Color.BLACK);
            //canvass.drawRect(rect, paint0);
            paint0.setTextSize(60);
            paint0.setColor(Color.WHITE);
            paint0.setStyle(Paint.Style.FILL_AND_STROKE);
            canvass.drawText("Brick Breaker", 347, 115, paint0);


            //first button
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvass.drawRect(rect, paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            canvass.drawRect(rect, paint);
            paint.setTextSize(55);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvass.drawText("Play Normal Mode", 300, 300, paint);

            //second button
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(Color.WHITE);
            canvass.drawRect(rect2, paint2);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(Color.BLACK);
            canvass.drawRect(rect2, paint2);
            paint2.setTextSize(55);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            canvass.drawText("Play Your Own Design", 265, 475, paint2);

            paint3.setStyle(Paint.Style.FILL);
            paint3.setColor(Color.WHITE);
            canvass.drawRect(rect3, paint3);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setColor(Color.BLACK);
            canvass.drawRect(rect3, paint3);
            paint3.setTextSize(55);
            paint3.setStyle(Paint.Style.FILL_AND_STROKE);
            canvass.drawText("Make Your Own Design", 255, 650, paint3);




        }

    }
    public void changeCondition() {
        condition = false;
    }


}


