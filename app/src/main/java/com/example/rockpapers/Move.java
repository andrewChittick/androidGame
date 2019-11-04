package com.example.rockpapers;

class Move {
    //private properties
    private String gesture;
    private String emoji;
    private float rotation;
    private String beats;

    Move(String move){
        gesture = move;
        if (gesture.equals("rock")){
            emoji = "\uD83D\uDC4A";
            rotation = 270;
            beats = "scissors";
        }
        else if (gesture.equals("paper")){
            emoji = "✋️";
            rotation = 0;
            beats = "rock";
        }
        else {//scissors
            emoji = "✌";
            rotation = 270;
            beats = "paper";
        }
    }
    String getGesture(){
        return this.gesture;
    }
    String getEmoji(){
        return this.emoji;
    }
    float getRotation(){
        return this.rotation;
    }
    String getBeats(){
        return this.beats;
    }
}
