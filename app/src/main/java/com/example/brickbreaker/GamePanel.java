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

        thread = new MainThread(getHolder(), this);

        player = new Paddle(new Rect(100, 100, 500, 150), Color.rgb(255, 0, 0));
        playerPoint = new Point(150, 150);
        circleRadius = 50;
        circleXpos = 300;
        circleYpos = 300;
        dx = 10;
        dy = 10;

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
        int paddleXpos;

        if (event.getX() - player.getWidth()/2 < 0) {
            paddleXpos = player.getWidth()/2;
        } else if (event.getX() + player.getWidth()/2 > rightBound) {
            paddleXpos = rightBound - player.getWidth()/2;
        } else {
            paddleXpos = (int) event.getX();
        }

        playerPoint.set(paddleXpos, 1500);
//        playerPoint.set((int) event.getX(), 1500);
    }

    public void update() {
        player.update(playerPoint);
    }

     @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 0, 0));
        canvas.drawColor(Color.WHITE);
        System.out.println("Top: " + topBound + "  Bottom: " + bottomBound);
        System.out.println("FUCK: " + circleRadius + " THIS: " + circleYpos);
        if (circleXpos + circleRadius >= rightBound || circleXpos - circleRadius <= leftBound) {
            dx *= -1;
        }
        if (circleYpos - circleRadius <= topBound || circleYpos + circleRadius >= bottomBound) {
            dy *= -1;
        }
//        Pair<Boolean, Integer> collisionResults = boxCircleCollision(playerPoint.x, playerPoint.y, player.getWidth(), player.getHeight(), circleXpos, circleYpos, circleRadius);
//        Boolean collision = collisionResults.first;
//        Integer side = collisionResults.second;
//        if (collision && side > 0) {
//            if (side == 5) {
//                dx *= -1;
//                dy *= -1;
//            } else if (side == 1 || side == 3) {
//                dy *= -1;
//            } else if (side == 2 || side == 4) {
//                dx *= -1;
//            }
//        }
        System.out.println("X: " + circleXpos + " Y: " + circleYpos + " dx: " + dx + " dy: " + dy);
        circleXpos += dx;
        circleYpos += dy;
        canvas.drawCircle(circleXpos, circleYpos, circleRadius, paint);

        player.draw(canvas);
    }

//    public Pair<Boolean, Integer> boxCircleCollision(int boxX, int boxY, int boxWidth, int boxHeight, int circleX, int circleY, int circleRadius) {
//        int closeX = circleX;
//        int closeY = circleY;
//        Integer side = -1;
//
//        if (circleY + circleRadius < boxY + boxHeight/2) {
//            closeY = boxY;
//            side = 1;
//        }
//        if (circleX - circleRadius > boxX + boxWidth/2) {
//            closeX = boxX + boxWidth;
//            side = 2;
//        }
//        if (circleY - circleRadius > boxY + boxHeight/2) {
//            closeY = boxY + boxHeight;
//            side = 3;
//        }
//        if (circleX + circleRadius < boxX - boxWidth/2) {
//            closeX = boxX;
//            side = 4;
//        }
//        if (closeX == boxX && closeY == boxY || closeX == boxX + boxWidth && closeY == boxY || closeX == boxX && closeY == boxY + boxHeight || closeX == boxX + boxWidth && closeY == boxY + boxHeight) {
//            side = 5;
//        }
//        double distance = Math.sqrt(Math.pow(closeX - circleX, 2) + Math.pow(closeY - circleY, 2));
//        Pair<Boolean, Integer> pair = new Pair((distance < circleRadius), side);
//        return pair;
//    }




}
