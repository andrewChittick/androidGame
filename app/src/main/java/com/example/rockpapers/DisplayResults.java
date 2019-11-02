package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResults extends AppCompatActivity {

    //EMOJI unicode constants here
    private final String FIST = "fist";
    private final String ROCK = "rock";
    private final String PAPER = "paper";
    private final String SCISSORS = "sciccors";
    private final String CRYFACE = "cryface";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userMove = extras.getString("userMove");
        String pcMove = extras.getString("pcMove");
        String result = extras.getString("result");

        // Capture the layout's TextView and set the string as its text
        TextView textViewLeft = findViewById(R.id.textView3);
        textViewLeft.setText(userMove);

        TextView textViewRight = findViewById(R.id.textView4);
        textViewRight.setText(pcMove);

        TextView textViewResult = findViewById(R.id.textView5);
        textViewResult.setText(result);
    }
}
