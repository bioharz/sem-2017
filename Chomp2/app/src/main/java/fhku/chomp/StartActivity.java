package fhku.chomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.start1).setOnClickListener(this);
        findViewById(R.id.start2).setOnClickListener(this);
        getSupportActionBar().hide();
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("mode", R.id.start1 == view.getId() ? 1 : 2);
        startActivity(i);
    }
}
