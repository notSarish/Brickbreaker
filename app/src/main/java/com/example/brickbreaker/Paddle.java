package com.example.brickbreaker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Paddle implements GameObject {

    private Rect paddle;
    private int color;
    private int circleRadius = 50;
    private Point circlePos = new Point(100, 100);

    public Paddle(Rect rectangle, int color) {
        this.paddle = rectangle;
        this.color = color;
    }

    public int getLeft() {
        return paddle.left;
    }
    public int getRight() {
        return paddle.right;
    }
    public int getTop() {
        return paddle.top;
    }
    public int getBottom() {
        return paddle.bottom;
    }

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
