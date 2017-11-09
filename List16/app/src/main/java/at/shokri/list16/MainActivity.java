package at.shokri.list16;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {

    int counter = 0;
    int counterMax = 10;
    Button[] buttons = new Button[10];
    TextView text;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    //Location last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(this);

            buttons[i].setText(String.valueOf(i + 1));

            buttons[i].setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.FILL_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.addView(buttons[i]);
            buttons[i].setOnClickListener(this);

        }

        //text = (TextView) findViewById(R.id.text); //TODO

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        Location last = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateWithNewLocation(last);



        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, this);



    }


    public void updateWithNewLocation(Location loc) {
        if (loc != null) {
            Log.i("updateWithNewLocation", "new location...: "+loc.getLatitude()+", "+loc.getLongitude());

            if(counter <= counterMax) {
                buttons[counter++].setText(loc.getLatitude()+", "+loc.getLongitude());
            } else {
                counter = 0;
                buttons[counter++].setText(loc.getLatitude()+", "+loc.getLongitude());

            }


        } else {
            Log.i("updateWithNewLocation", "location is null");
        }
    }


    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        //Toast.makeText(this, "Button " + b.getText(), Toast.LENGTH_SHORT).show();

        /*
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        Location last = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //updateWithNewLocation(last);
        Toast.makeText(this, last.getLatitude()+", "+last.getLongitude(), Toast.LENGTH_SHORT).show();

        */
    }


    @Override
    public void onLocationChanged(Location location) {

        updateWithNewLocation(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
