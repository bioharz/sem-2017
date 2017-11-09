package fhkufstein.ac.at.ue2_chomp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    protected int player = 1;
    protected int[] player_points = new int[2]; //Player 1 = index = 0 // Player 2 = index = 1
    protected int mode;
    protected GridLayout grid;
    protected Piece[] pieces = new Piece[35]; //piece wie button nur selbst gemacht
    protected Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getSupportActionBar().hide();
        //Standard highscore 0
        player_points[0] = 0;
        player_points[1] = 0;

        mode = getIntent().getIntExtra("mode",2); //wenn empty or similar dann 2 als default
        Log.i("CHOMP", "mode = "+mode);

        grid = (GridLayout) findViewById(R.id.grid);
        grid.setColumnCount(5);

        for (int i = 0;i<35;i++) {
            pieces[i]=new Piece(this); //,null,R.style.chocolate_piece als zusätzliche Parameter um Style zuzuweisen

            if (i==0) {
                pieces[i].setEnabled(false);
                pieces[i].setText("X");
                pieces[i].setTextColor(Color.RED);
            } else {
                pieces[i].setText("F:"+i);
                pieces[i].setOnClickListener(this);
                pieces[i].setTag(i); //jedes view element kann eins oder mehrere Tags haben. Zum einfacher identifizieren/gruppieren
            }
            grid.addView(pieces[i]); //statt Button jetzt Piece, da wir eine neue Subklasse erstellt haben
        }
    }

    @Override
    public void onClick(View v) {
        removePieces((int) v.getTag()); //haben oben einen Tag hinterlegt, wo der Index gespeichert wird.
        updateGame();
        if (mode==1) { //if singleplayer
            computerTurn();
        }
    }

    public void removePieces(int index) {
        int reference = index % 5;
        for (int i = index;i<35;i++) {
            if (pieces[i].isEnabled() && i%5 >= reference) {
                removePiece(i);
            }
        }
    }

    public void removePiece(int index) {
        pieces[index].setEnabled(false); //Piece nun nicht mehr anklickbar

        //Update Highscore
        TextView points = (TextView) findViewById(R.id.points);
        points.setText(String.valueOf(++player_points[player-1])); //Player 1 = index = 0 // Player 2 = index = 1

        ObjectAnimator animator = ObjectAnimator.ofFloat(pieces[index],"alpha",1,0); //Statt sofort transparent mit Animation
        animator.setDuration(1000);
        animator.start();
        //pieces[index].setAlpha(0); //Transparenz auf 0 so nicht mehr sichtbar
    }

    public void updateGame() {
        player = (player==1) ? 2 :1;
        ((TextView) findViewById(R.id.player)).setText("Player "+player);

        for (int i = 0;i<35;i++) {
            if (pieces[i].isEnabled()) {
                return; //Methode wird beendet
            }
        }

        Intent i = new Intent(this,GameOverActivity.class);
        i.putExtra("looser",player);
        i.putExtra("winner",player == 1 ? 2 : 1);
        startActivity(i);
    }

    public void computerTurn() {
        int rand; //one of 34 (first field excluded) fields , FIRST TURN OF COMPUTER
        /*Toast.makeText(this,"PC TURN: "+rand,Toast.LENGTH_SHORT).show();
        Log.e("RAND","START: "+rand);*/
        int[] enabledFields = getEnabledFields();
        try {
            rand = r.nextInt(((enabledFields.length - 1) - 1) + 1) + 1;
            removePieces(rand);
        } catch (Exception e) {
            Log.e("Game","Game OVER");
        }

        updateGame();
    }

    public int[] getEnabledFields() {
        //Piece[] enabledFields;
        int[] pieces_int;
        String indizes = "";
        int k = 0;
        for (int i = 0;i<35;i++) {
            if (pieces[i].isEnabled()) {
                //pieces_int[k++] = i;
                if ((k++)!=0) {
                    indizes += "&";
                }
                indizes += i;
            }
        }

        /*enabledFields = new Piece[k];
        for (int a = 0;a<=k;a++) {
            enabledFields[a] = pieces[pieces_int[a]];
        }*/
        String[] indizes_arr = indizes.split("&");
        pieces_int = new int[indizes_arr.length];
        int j = 0;
        for (String piece:indizes_arr) {
            if (!piece.equals("")) {
                pieces_int[j++] = Integer.parseInt(piece);
            }
        }
        return pieces_int;
    }
}
