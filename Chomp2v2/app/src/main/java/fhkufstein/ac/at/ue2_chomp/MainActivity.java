package fhkufstein.ac.at.ue2_chomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mode1).setOnClickListener(this);
        findViewById(R.id.mode2).setOnClickListener(this);
        getSupportActionBar().hide();
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, GameActivity.class); //expliziter Intent
        i.putExtra("mode",R.id.mode1 == v.getId() ? 1 : 2); //mode 1 oder 2 gedrückt?
        startActivity(i);
    }
}
