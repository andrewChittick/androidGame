package com.example.rockpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static android.animation.ObjectAnimator.ofFloat;

public class DisplayResults extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        // Get the Intent that started this activity and extract the strings
        Intent intent = getIntent();
        final Bundle results = intent.getExtras();


        TextView userView = findViewById(R.id.userView);
        TextView pcView = findViewById(R.id.pcView);
        TextView judgementView = findViewById(R.id.judgementView);

        animate(userView, pcView, judgementView, results);
    }

    private void animate(final TextView userView, final TextView pcView, final TextView judgementView, final Bundle results) {
        //make fists
        userView.setText("\uD83D\uDC4A");
        pcView.setText("\uD83D\uDC4A");

        //make animation sequences
        AnimatorSet userSequence = upDownSequence(userView);
        AnimatorSet pcSequence = upDownSequence(pcView);

        //combine/play animation sequences concurrently, then display the results
        AnimatorSet allAnimations = new AnimatorSet();
        allAnimations.playTogether(userSequence, pcSequence);
        allAnimations.start();
        allAnimations.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation){
                displayResults(results, userView, pcView, judgementView);
            }
        });
    }


    AnimatorSet upDownSequence(TextView view){
        ObjectAnimator[] animation = new ObjectAnimator[6];

        //go up and down 6 times
        //up
        animation[0] = ObjectAnimator.ofFloat(view, "translationY", -500f);
        animation[0].setDuration(1000);
        //down
        animation[1] = ofFloat(view, "translationY", 0f);
        animation[1].setDuration(1000);
        //even (up)
        for (int i = 2; i<6; i+=2) {
            animation[i] = animation[0].clone();
        }
        //odd (down)
        for (int i = 3; i<6; i+=2) {
            animation[i] = animation[1].clone();
        }
        //make a sequence of animations
        AnimatorSet sequence = new AnimatorSet();
        sequence.playSequentially(
                animation[0],
                animation[1],
                animation[2],
                animation[3],
                animation[4],
                animation[5]);
        return sequence;
    }


    private void displayResults(Bundle results, TextView userView, TextView pcView, TextView judgementView) {
        //user move
        userView.setText(results.getString("userEmoji"));
        userView.setRotation(results.getFloat("userRotation"));
        //pc move
        pcView.setText(results.getString("pcEmoji"));
        pcView.setRotation(results.getFloat("pcRotation"));
        //judgement day
        judgementView.setText(results.getString("judgement"));
    }
}
