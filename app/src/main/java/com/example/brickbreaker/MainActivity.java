package com.example.brickbreaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;


import static android.view.Window.FEATURE_NO_TITLE;
//import android.widget.Button;
//import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private Canvas canvas = new Canvas();
    private Color color = new Color();
    DrawView drawView;
    drawView2 drawview2;
    GamePanel b; //= new GamePanel(this);
    boolean isItPlaying = false;
    boolean weInCustomMake = false;
    boolean inNormalMode = false;
    Bricks[][] a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //buttons
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
       // b = new GamePanel(this);

//        ViewFlipper flipper = drawView;
       // b.setVisibility(View.GONE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //RelativeLayout a = new DrawView(this);
        //DrawView a = new DrawView(this);
        //b.setVisibility(View.GONE);
        //drawView.setVisibility(View.VISIBLE);
        setContentView(drawView);




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //what happens if you touch the first button

       // if (inNormalMode) {
            //if within the boundaries of the back button
            //setContentView(drawView)
         //   inNormalMode = false;
        //}
        //what happens if you touch the second button
       /* if (drawView.getVisibility() != View.GONE && x >= 0 && x <= 1500 && y >= 375 && y <= 525) {
            //setContentView to the self made design game

            return true;
        }


*/      if (weInCustomMake && !inNormalMode) { //&& x >= 0 && x<=1500 && y >= 0 && y <= 875) {
            //keep adding 1 to the color for each touch
            //badda bing

            int xordinate = (int) x/270;
            int yCoordinate = (int) y/175;
            //if (x < 4 && y < 5) {

            int col = a[xordinate][yCoordinate].getColor();
            a[xordinate][yCoordinate].setColor(col);
            //}
            drawview2 = new drawView2(this, a);
            setContentView(drawview2);
            return true;
            //have a back statement to get out
        }
        if (!weInCustomMake && drawView.getVisibility() != View.GONE && !inNormalMode && x >= 0 && x <= 1500 && y >= 550 && y <= 700) {
            //setContentView to the make your own design page
            a = new Bricks[5][4];
            drawview2 = new drawView2(this, a);
            setContentView(drawview2);
            drawView.setVisibility(View.GONE);
            weInCustomMake = true;

            return true;
        }
        
        //
        if (!weInCustomMake && drawView.getVisibility() != View.GONE && x >= 0 && x <= 1500 && y >= 200 && y <= 350) {


            setContentView(new GamePanel(this));
            drawView.setVisibility(View.GONE);
            inNormalMode = true;

            return true;
        }

        return false;
    }


}
