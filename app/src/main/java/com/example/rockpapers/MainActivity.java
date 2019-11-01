package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    //EMOJI code constants here
    public static final String FIST = "fist";
    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "sciccors";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginGame(View view) {
        //onclick get button
        String userMove = "rocks";
        Game g = Game.getInstance();

        //play the game
        g.playGame(userMove);

        Intent intent = new Intent(this, DisplayResults.class);

        //bundle all the game data
        Bundle extras = new Bundle();
        extras.putString("userMove", g.getUserMove());
        //for rotation
        // extras.putStringArrayList("userMove", g.getUserMove());
        extras.putString("pcMove", g.getPcMove());
        extras.putString("result", g.getResult());
        intent.putExtras(extras);

        //start game animation
        startActivity(intent);
    }
}
