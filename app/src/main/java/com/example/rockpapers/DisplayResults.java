package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        // Get the Intent that started this activity and extract the strings
        Intent intent = getIntent();
        Bundle results = intent.getExtras();

        displayResults(results);
    }

    private void displayResults(Bundle results) {
        TextView textView;
        //user move
        textView = findViewById(R.id.userView);
        setMove(textView, results.getString("userEmoji"), results.getFloat("userRotation"));
        //pc move
        textView = findViewById(R.id.pcView);
        setMove(textView, results.getString("pcEmoji"), results.getFloat("pcRotation"));
        //judgement day
        textView = findViewById(R.id.judgementView);
        textView.setText(results.getString("judgement"));
    }

    private void setMove(TextView move, String emoji, float rotation) {
        move.setText(emoji);
        move.setRotation(rotation);
    }
}
