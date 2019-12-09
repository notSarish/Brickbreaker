package com.example.brickbreaker;


import android.graphics.Rect;

import java.util.ArrayList;

public class LevelMaker {
    public ArrayList<Brick> level;

    final private int ROWS = 5;
    final private int COLS = 4;

    public LevelMaker(int[][] toRender) {
        if (toRender.length != ROWS || toRender[0].length != COLS) {
            throw new IllegalArgumentException();
        }
        level = new ArrayList<Brick>();
        level.add(new Brick(new Rect(150, 100, 300, 150), 3));
        level.add(new Brick(new Rect(360, 100, 510, 150), 3));
        level.add(new Brick(new Rect(570, 100, 720, 150), 3));
        level.add(new Brick(new Rect(780, 100, 930, 150), 3));

        level.add(new Brick(new Rect(150, 200, 300, 250), 3));
        level.add(new Brick(new Rect(360, 200, 510, 250), 3));
        level.add(new Brick(new Rect(570, 200, 720, 250), 3));
        level.add(new Brick(new Rect(780, 200, 930, 250), 3));

        level.add(new Brick(new Rect(150, 300, 300, 350), 3));
        level.add(new Brick(new Rect(360, 300, 510, 350), 3));
        level.add(new Brick(new Rect(570, 300, 720, 350), 3));
        level.add(new Brick(new Rect(780, 300, 930, 350), 3));

        level.add(new Brick(new Rect(150, 400, 300, 450), 3));
        level.add(new Brick(new Rect(360, 400, 510, 450), 3));
        level.add(new Brick(new Rect(570, 400, 720, 450), 3));
        level.add(new Brick(new Rect(780, 400, 930, 450), 3));

        level.add(new Brick(new Rect(150, 500, 300, 550), 3));
        level.add(new Brick(new Rect(360, 500, 510, 550), 3));
        level.add(new Brick(new Rect(570, 500, 720, 550), 3));
        level.add(new Brick(new Rect(780, 500, 930, 550), 3));

        int counter = 0;
        for (int n = 0; n < ROWS; n++) {
            for (int i = 0; i < COLS; i++) {
                level.get(counter).setLife(toRender[n][i]);
                counter++;
            }
        }
    }
}
