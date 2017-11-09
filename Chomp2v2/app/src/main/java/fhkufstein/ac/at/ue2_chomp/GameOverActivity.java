package fhkufstein.ac.at.ue2_chomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int looser = getIntent().getIntExtra("looser",1); //standard value is 1
        int winner = getIntent().getIntExtra("winner",2);
        TextView looserView = (TextView) findViewById(R.id.looser);
        TextView winnerView = (TextView) findViewById(R.id.winner);
        looserView.setText((String) looserView.getText()+looser);
        winnerView.setText((String) winnerView.getText()+winner);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
