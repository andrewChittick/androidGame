package com.example.rockpapers;

class Game {
    /*for singleton*/
    private static final Game ourInstance = new Game();

    static Game getInstance() {
        return ourInstance;
    }

    /*game private properties*/
    private String userMove;
    private String pcMove;
    private String result;

    /*Game methods*/
    private Game() {
        //default error state
        this.userMove = "CRYFACE";
        this.pcMove = "CRYFACE";
        this.result = "error";
    }

    private void setUserMove(String move){
        this.userMove = move;
    }

    private void setPcMove(){
        //set pc move
        double randomNum = (Math.random() * 3);
        if (randomNum < 1) {
            this.pcMove = "ROCK";
        }
        else if (randomNum < 2) {
            this.pcMove = "PAPER";
        }
        else{
            this.pcMove = "SCISSORS";
        }
    }

    private void setResult(){
        //set result
        if (getUserMove().equals(getPcMove())){
            this.result = "tie";
        }
        else if (getUserMove().equals("ROCK")){
            if (getPcMove().equals("SCISSORS")){
                this.result = "Winner!";
            }
            else{
                this.result = "Loser!";
            }
        }
        else if (getUserMove().equals("PAPER")){
            if (getPcMove().equals("ROCK")){
                this.result = "Winner!";
            }
            else{
                this.result = "Loser!";
            }
        }
        else{//SCISSORS
            if (getPcMove().equals("PAPER")){
                this.result = "Winner!";
            }
            else{
                this.result = "Loser!";
            }
        }
    }

    void playGame(String move){
        setUserMove(move);
        setPcMove();
        setResult();
    }

    String getUserMove(){
        return this.userMove;
    }

    String getPcMove(){
        return this.pcMove;
    }

    String getResult(){
        return this.result;
    }

}
