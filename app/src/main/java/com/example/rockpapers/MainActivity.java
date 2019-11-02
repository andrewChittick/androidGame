package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginGame(View view) {
        //start the game
        Game g = Game.getInstance();

        //onclick get button pressed (move)
        int buttonPressed = view.getId();

        //play the game with appropriate user move
        if (buttonPressed == R.id.rock){
            g.playGame("ROCK");
        }
        else if (buttonPressed == R.id.paper){
            g.playGame("PAPER");
        }
        else if (buttonPressed == R.id.scissors){
            g.playGame(("SCISSORS"));
        }

        Intent intent = new Intent(this, DisplayResults.class);

        //bundle all the game data
        Bundle extras = new Bundle();
        extras.putString("userMove", g.getUserMove());
        extras.putString("pcMove", g.getPcMove());
        extras.putString("result", g.getResult());
        intent.putExtras(extras);

        //start game animation
        startActivity(intent);
    }
}
