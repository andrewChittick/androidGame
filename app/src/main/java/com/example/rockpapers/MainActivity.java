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
        g.playGame(getInput(view.getId()));

        Intent intent = new Intent(this, DisplayResults.class);
        intent.putExtras(g.getResults());

        //start game animation
        startActivity(intent);
    }

    private String getInput(int buttonPressed){
        //return with appropriate user move
        if (buttonPressed == R.id.rock){
            return ("rock");
        }
        else if (buttonPressed == R.id.paper){
            return ("paper");
        }
        else{
            return ("scissors");
        }
    }
}
