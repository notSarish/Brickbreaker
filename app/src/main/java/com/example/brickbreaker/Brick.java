package com.example.brickbreaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Brick implements GameObject {
    private Rect brick;
    private int life;

    public int x;
    public int y;

    private int width;
    private int height;


    final private int[] COLORS = {Color.rgb(255, 255, 255),
            Color.rgb(223,227,238),
            Color.rgb(139,157,195),
            Color.rgb(59,89,152)};

    public Brick(Rect b, int life) {
        this.brick = b;
        this.life = life;

    }

    public int getLeft() {
        return x - brick.width()/2;
    }
    public int getRight() {
        return x + brick.width()/2;
    }
    public int getTop() { return y - brick.height()/2; }
    public int getBottom() { return y + brick.height()/2; }

    public int[] getDims() {
        int[] n = {getLeft(), getTop(), getRight(), getBottom()};
        return n;
    }

    public int getWidth() { return brick.width(); }
    public void setWidth(int w) { this.width = w; }
    public int getHeight() { return brick.height(); }
    public void setHeight(int h) { this.height = h; }

    public void setLife(int l) {
        this.life = l;
    }
    public int getLife() {
        return life;
    }


    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(COLORS[life]);
        canvas.drawRect(brick, paint);
        x = brick.centerX();
        y = brick.centerY();
    }

    @Override
    public void update() {

    }

    public void decrementLife() {
        life--;
    }
}
