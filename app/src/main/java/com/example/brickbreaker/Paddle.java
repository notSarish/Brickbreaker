package com.example.brickbreaker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Paddle implements GameObject {

    private Rect paddle;
    private int color;

    public Paddle(Rect rectangle, int color) {
        this.paddle = rectangle;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(paddle, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point) {
        paddle.set(point.x - paddle.width()/2, point.y - paddle.height()/2, point.x + paddle.width()/2, point.y + paddle.height()/2);

    }
}
