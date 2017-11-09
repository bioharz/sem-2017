package at.shokri.ballgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    protected Pad pad;
    protected FrameLayout game;
    protected View touchpad;
    protected Ball ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        pad = new Pad(this);
        ball = new Ball(this);
        ball.setPad(pad);
        game = (FrameLayout) findViewById(R.id.game);
        touchpad = findViewById(R.id.touchpad);

        touchpad.setOnTouchListener(this);

        touchpad.setOnTouchListener(this);
        game.addView(pad);
        game.addView(ball);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        float nextX = motionEvent.getX();

        if (nextX <= game.getWidth() - pad.getWidth()) {
            pad.setX(nextX);

        }


        return true;

    }
}
