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


import com.example.brickbreaker.DrawView;
import com.example.brickbreaker.GamePanel;

import static android.view.Window.FEATURE_NO_TITLE;
//import android.widget.Button;
//import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private Canvas canvas = new Canvas();
    private Color color = new Color();
    DrawView drawView;
    GamePanel b; //= new GamePanel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //buttons
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
       // b = new GamePanel(this);

//        ViewFlipper flipper = drawView;

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
        if (drawView.getVisibility() != View.GONE && x >= 0 && x <= 1500 && y >= 200 && y <= 350) {
          //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
           // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
           // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
           // b = new GamePanel(this);
            //drawView.setVisibility(View.GONE);
            //b.setVisibility(View.VISIBLE);
            setContentView(new GamePanel(this));
            drawView.setVisibility(View.GONE);
         //   drawView = null;
            return true;
        }
        //what happens if you touch the second button
       /* if (drawView.getVisibility() != View.GONE && x >= 0 && x <= 1500 && y >= 375 && y <= 525) {
            //setContentView to the self made design game

            return true;
        }

        if (drawView.getVisibility() != View.GONE && x >= 0 && x <= 1500 && y >= 550 && y <= 700) {
            //setContentView to the make your own design page
            return true;
        }*/
        return false;
    }


}
