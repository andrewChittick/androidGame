package com.example.rockpapers;

class Game {
    private static final Game ourInstance = new Game();

    static Game getInstance() {
        return ourInstance;
    }

    private String userMove;
    private String pcMove;

    //TODO
    //all game data stored here


    public String getUserMove(){
        return this.userMove;
    }

    public void setUserMove(String move){
        this.userMove = move;
    }


    private Game() {
        userMove = "move";
    }
}
