package com.example.rockpapers;

import android.os.Bundle;

class Game {
    /*for singleton*/
    private static final Game ourInstance = new Game();

    static Game getInstance() {
        return ourInstance;
    }

    private Bundle results;

    /*Game methods*/
    private Game() {
        results = new Bundle();
    }

    private String setPcMove(){
        //random number 0-3
        double randomNum = (Math.random() * 3);
        if (randomNum < 1) {
            return("rock");
        }
        else if (randomNum < 2) {
            return("paper");
        }
        else{
            return("scissors");
        }
    }

    private String setJudgement(Move user, Move pc){
        if (user.getGesture().equals(pc.getGesture())){return("tie");}
        else if (user.getBeats().equals(pc.getGesture())){return("Winner!");}
        else {return("Loser!");}
    }

    private void setResults(Move user, Move pc, String judgement) {
        //extract/Bundle info
        this.results.putString("userEmoji", user.getEmoji());
        this.results.putFloat("userRotation", user.getRotation());

        this.results.putString("pcEmoji", pc.getEmoji());
        this.results.putFloat("pcRotation", pc.getRotation());

        this.results.putString("judgement", judgement);
    }

    void playGame(String move) {
        Move user = new Move(move);
        Move pc = new Move(setPcMove());
        setResults(user, pc, setJudgement(user, pc));
    }

    Bundle getResults(){
        return this.results;
    }

    /*contains properties for moves*/
    static class Move {
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
}
