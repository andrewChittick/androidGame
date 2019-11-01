package com.example.rockpapers;

import static com.example.rockpapers.MainActivity.PAPER;

class Game {
    /*for singleton*/
    private static final Game ourInstance = new Game();

    static Game getInstance() {
        return ourInstance;
    }

    /*game properties TODO(make moves arrays w/rotation)*/
    private String userMove;
    private String pcMove;
    private String result;


    /*Game private methods*/

    private Game() {
        errorState();
    }

    private void errorState(){
        //set all game data to a safe, error state
        setUserMove("test");
        this.pcMove = "err";
        this.result = "error";
    }

    private boolean validateInput(String move){
        return (move == "rock" || move == "paper" || move == "scissors");
    }

    private void setUserMove(String move){
        this.userMove = move;
    }

    private void setPcMove(){
        //set pc move
        this.pcMove = PAPER;
    }

    private void setResult(){
        //set result
        this.result = "winner";
    }

    /*public Game methods*/

    public void playGame(String move){
        if (validateInput(move)){
            setUserMove(move);
            setPcMove();
            setResult();
        }
        else{
            errorState();
        }
    }

    public String getUserMove(){
        return this.userMove;
    }

    public String getPcMove(){
        return this.pcMove;
    }

    public String getResult(){
        return this.result;
    }
}
