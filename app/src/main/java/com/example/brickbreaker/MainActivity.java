package com.example.brickbreaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));

//        setContentView(R.layout.activity_main);
//        Button normal = (Button) findViewById(R.id.playNormal);
//        View.OnClickListener handler = new View.OnClickListener(){
//            public void onClick(View v) {
//                Intent normalIntent = new Intent(MainActivity.this, NormalModeActivity.class);
//                MainActivity.this.startActivity(normalIntent);
//            }
//        };
//        normal.setOnClickListener(handler);
    }
//
//    private void normalModeClickHandler() {
//        Intent normalIntent = new Intent(MainActivity.this, NormalMode.class);
//        MainActivity.this.startActivity(normalIntent);
//    }
}
