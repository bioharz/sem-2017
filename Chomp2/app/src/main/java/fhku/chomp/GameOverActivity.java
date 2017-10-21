package fhku.chomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int looser = getIntent().getIntExtra("looser", 1);

        TextView winnerView = (TextView) findViewById(R.id.winner);
        TextView looserView = (TextView) findViewById(R.id.looser);

        looserView.setText((String) looserView.getText() + looser);
        winnerView.setText((String) winnerView.getText() + (looser == 1 ? 2 : 1));
    }
}
