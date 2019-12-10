package com.example.brickbreaker;

import android.graphics.Rect;

public class Bricks {
    Rect rect;
    int color;
    public Bricks (Rect a, int c) {
        rect = a;
        color = c;
    }

    public int getColor() {
        return color;
    }
    public void incrementColor() {
        if (color == 3) {
            color = 0;
        } else {
            color++;
        }
    }
    public Rect getRect() {
        return rect;
    }
}
