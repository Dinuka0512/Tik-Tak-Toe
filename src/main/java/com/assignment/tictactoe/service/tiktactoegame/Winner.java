package com.assignment.tictactoe.service.tiktactoegame;

public class Winner {
    private Piece winnerPiese;

    Winner(Piece winnerPiese){
        this.winnerPiese = winnerPiese;
    }

    public Piece getWinnerPiese() {
        return winnerPiese;
    }

    public void setWinnerPiese(Piece winnerPiese) {
        this.winnerPiese = winnerPiese;
    }
}
