package com.example.brickbreaker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Paddle implements GameObject {

    private Rect paddle;
    private int color;

    public int x;
    public int y;

    public Paddle(Rect rectangle, int color) {
        this.paddle = rectangle;
        this.color = color;
        x = rectangle.centerX();
        y = rectangle.centerY();
    }

    public int getLeft() {
        return x - paddle.width()/2;
    }
    public int getRight() {
        return x + paddle.width()/2;
    }
    public int getTop() {
        return y - paddle.height()/2;
    }
    public int getBottom() { return y + paddle.height()/2; }

    public int getWidth() {
        return paddle.width();
    }
    public int getHeight() {
        return paddle.height();
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        x = paddle.centerX();
        y = paddle.centerY();
        canvas.drawRect(paddle, paint);
//        canvas.drawCircle(circlePos.x, circlePos.y, circleRadius, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point) {
        paddle.set(point.x - paddle.width()/2, point.y - paddle.height()/2, point.x + paddle.width()/2, point.y + paddle.height()/2);

    }
}
