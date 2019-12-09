package com.example.brickbreaker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.util.ArrayList;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private Paddle player;
    private Point playerPoint;

    private int circleRadius;
    private int circleXpos;
    private int circleYpos;
    private int dx;
    private int dy;

    private int leftBound;
    private int rightBound;
    private int topBound;
    private int bottomBound;

    private int paddleXpos;
    final private int paddleYpos = 1500;

    private ArrayList<Brick> currentLevel;

    public GamePanel(Context context) {
        super(context);

        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        leftBound = 0;
        rightBound = size.x;
        topBound = 0;
        bottomBound = size.y;
        getHolder().addCallback(this);

        int[][] toRender = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        currentLevel = (new LevelMaker(toRender)).level;

        thread = new MainThread(getHolder(), this);

        player = new Paddle(new Rect(100, 100, 350, 120), Color.rgb(255, 0, 0));
        playerPoint = new Point(rightBound/2, 1500);
        circleRadius = 35;
        circleXpos = rightBound/2;
        circleYpos = 1000;
        dx = 7;
        dy = 7;

        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
         thread = new MainThread(getHolder(), this);

         thread.setRunning(true);
         thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (true) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                movePlayer(event);

        }
        return true;
    }
    private void movePlayer(MotionEvent event) {

        if (event.getX() - player.getWidth()/2 < 0) {
            paddleXpos = player.getWidth()/2;
        } else if (event.getX() + player.getWidth()/2 > rightBound) {
            paddleXpos = rightBound - player.getWidth()/2;
        } else {
            paddleXpos = (int) event.getX();
        }

        playerPoint.set(paddleXpos, paddleYpos);
//        playerPoint.set((int) event.getX(), 1500);
    }

    public void update() {
//        System.out.println("X: " + paddleXpos + " Y: " + (player.getTop() - player.getBottom())/2);
        player.update(playerPoint);
    }

     @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 0, 0));
        canvas.drawColor(Color.WHITE);
//        System.out.println("Top: " + topBound + "  Bottom: " + bottomBound);
//        System.out.println("FUCK: " + circleRadius + " THIS: " + circleYpos);
        if (circleXpos + circleRadius >= rightBound || circleXpos - circleRadius <= leftBound) {
            dx *= -1;
        }
        if (circleYpos - circleRadius <= topBound || circleYpos + circleRadius >= bottomBound) {
            dy *= -1;
        }
        Pair<Boolean, Integer> collisionResults = boxCircleCollision(player.x, player.y, player.getWidth(), player.getHeight(), circleXpos, circleYpos, circleRadius);
//        System.out.println("Top: " + player.getTop() + " Right: " + player.getRight() + " Bottom: " + player.getBottom() + " Left: " + player.getLeft());
//        System.out.println("X: " + circleXpos + "  Y: " + circleYpos);
        Boolean collision = collisionResults.first;
        Integer side = collisionResults.second;
        if (collision && side > 0) {
//            System.out.println(side);
            if (side == 1 || side == 3) {
                dy *= -1;
            } else if (side == 2 || side == 4) {
                dx *= -1;
            } else {
                dx *= -1;
                dy += -1;
            }
        }
        if (checkIfCleared()) {
            dx = 0;
            dy = 0;
        } else {
            renderGrid(canvas);
        }

//        System.out.println("X: " + circleXpos + " Y: " + circleYpos + " dx: " + dx + " dy: " + dy);
        circleXpos += dx;
        circleYpos += dy;
        canvas.drawCircle(circleXpos, circleYpos, circleRadius, paint);



        player.draw(canvas);
    }

    public boolean checkIfCleared(){
        for (int n = 0; n < currentLevel.size(); n++) {
            if (currentLevel.get(n).getLife() > 0) {
                return false;
            }
        }
        return true;
    }

    public void renderGrid(Canvas canvas) {
        System.out.println("Frame Start");
        for (int n = 0; n < currentLevel.size(); n++) {
            Brick current = currentLevel.get(n);
            Pair<Boolean, Integer> collisionResults = boxCircleCollision(current.x, current.y, current.getWidth(), current.getHeight(), circleXpos, circleYpos, circleRadius);
            System.out.println(collisionResults);
            System.out.println("W: " + current.getWidth() + " H: " + current.getHeight());
            Boolean collision = collisionResults.first;
            Integer side = collisionResults.second;
            if (collision && side > 0 && current.getLife() > 0) {
                current.decrementLife();
                if (side == 1 || side == 3) {
                    dy *= -1;
                } else if (side == 2 || side == 4) {
                    dx *= -1;
                } else {
                    dx *= -1;
                    dy *= -1;
                }
            }
            if (current.getLife() > 0) {
                current.draw(canvas);
            }
        }
    }

    public Pair<Boolean, Integer> boxCircleCollision(int boxX, int boxY, int boxWidth, int boxHeight, int circleX, int circleY, int circleRadius) {
//        int closeX = circleX;
//        int closeY = circleY;
//        Integer side = -1;

        double cx = Math.abs(circleX - boxX);
        double cy = Math.abs(circleY - boxY);

        if (cx > (boxWidth/2 + circleRadius) || (cy > boxHeight/2 + circleRadius)) {
            return new Pair(false, -1);
        }
        if (cx <= (boxWidth/2)) {
            return new Pair(true, 1);
        }
        if (cy <= (boxHeight/2)) {
            return new Pair(true, 2);
        }
        double corner = Math.pow((cx - boxWidth/2), 2) + Math.pow((cy - boxHeight/2), 2);
        return new Pair(corner < (circleRadius^2), 5);

//        if (circleX < boxX) {
//            closeX = boxX;
//            side = 4;
//        } else if (circleX > boxX + boxWidth) {
//            closeX = boxX + boxWidth;
//
//        int closeX = circleX;
//        int closeY = circleY;
//        Integer side = -1;side = 2;
//        }
//        if (circleY < boxY) {
//            closeY = boxY;
//            side = 1;
//        } else if (circleY > boxY + boxHeight) {
//            closeY = boxY + boxHeight;
//            side = 3;
//        }

//        if (circleY < boxY) {
//            closeY = boxY;
//            side = 1;
//        } else if (circleY > boxY + boxHeight) {
//            closeY = boxY + boxHeight;
//            side = 3;
//        }
//        if (circleX > boxX + boxWidth) {
//            closeX = boxX + boxWidth;
//            side = 2;
//        } else if (circleX < boxX) {
//            closeX = boxX;
//            side = 4;
//        }
////        if (closeX == boxX && closeY == boxY || closeX == boxX + boxWidth && closeY == boxY || closeX == boxX && closeY == boxY + boxHeight || closeX == boxX + boxWidth && closeY == boxY + boxHeight) {
////            side = 5;
////        }
//        float distX = circleX - closeX;
//        float distY = circleY - closeY;
//        double distance = Math.sqrt((distX * distY) + (distY * distY));
//        Pair<Boolean, Integer> pair = new Pair((distance < circleRadius), side);
//        return pair;

    }

    private double clamp(double min, double max, double value) {
        if (value < min) {
            return min;
        } else if (value > min) {
            return max;
        } else {
            return value;
        }
    }



}
