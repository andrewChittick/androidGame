package com.example.rockpapers;

class Game {
    private static final Game ourInstance = new Game();

    static Game getInstance() {
        return ourInstance;
    }

    //game properties
    private String userMove;
    private String pcMove;
    private String result;


    //game methods
    public String getUserMove(){
        return this.userMove;
    }

    public void setUserMove(String move){
        this.userMove = move;
    }

    public void playGame(String move){
        //validate input
        setUserMove(move);
        //setPcMove;
        //setResults;
        //else {errorState()};
    }

    public String getPcMove(){
        return this.pcMove;
    }

    public String getResult(){
        return this.result;
    }


    private Game() {
        //set defaults
        //errorState();
        this.userMove = "move";
        this.pcMove = "pcMove";
        this.result = "error";
    }
}
