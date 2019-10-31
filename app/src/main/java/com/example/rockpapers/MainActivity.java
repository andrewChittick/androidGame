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

    public void beginGame(View view){
      //begin game
      Intent intent = new Intent(this, DisplayResults.class);
      String userMove = "hi";
      String pcMove = "bob";
      //Game game = new Game(button);
      //String message = game.result;

        //intent.putExtra(EXTRA_MESSAGE, userMove);

      Bundle extras = new Bundle();
      extras.putString("userMove", userMove);
      extras.putString("pcMove", pcMove);
      intent.putExtras(extras);

      startActivity(intent);
    }

    public void ame(){
        //do stuff
        //Intent intent = new Intent(this, DisplayResults.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //String message = "\ud83d\udc3b";
        //result = message;
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
}
