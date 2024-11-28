package com.assignment.tictactoe.service.tiktactoegame;

public abstract class Player {
    protected BoardImpl board;

    Player(BoardImpl board){
        this.board = board;
    }
    public abstract void move(int row, int cal);
}
