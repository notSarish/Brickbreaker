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


import static android.view.Window.FEATURE_NO_TITLE;
//import android.widget.Button;
//import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private Canvas canvas = new Canvas();
    private Color color = new Color();
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if (x >= 0 && x <= 1500 && y >= 200 && y <= 350) {
          //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
           // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(new GamePanel(this));
            return true;
        }
        return false;
    }


}
