package at.shokri.ninemensmorris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = new Board(this);
        board.setBackgroundColor(Color.BLACK);
        setContentView(board);
    }
}
