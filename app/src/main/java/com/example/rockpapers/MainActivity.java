package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "bob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginGame(View view) {
        String userMove = "onclick event";
        Game g = Game.getInstance();

        //set all game data
        g.setUserMove(userMove);
        //run game somehow

        Intent intent = new Intent(this, DisplayResults.class);


        Bundle extras = new Bundle();
        extras.putString("userMove", g.getUserMove());
        extras.putString("pcMove", g.getPcMove());
        //extras.putString("result", g.getResult());
        intent.putExtras(extras);

        startActivity(intent);
    }
}
