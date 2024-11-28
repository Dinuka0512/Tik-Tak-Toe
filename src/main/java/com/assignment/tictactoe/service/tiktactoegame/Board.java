package com.assignment.tictactoe.service.tiktactoegame;

public interface Board {
    void initializeBoard();
    //By useing the initializeBoardze methord we can reset the board

    boolean isLegalMove(int row, int cal);
    //In this is leagal methord we can check is it leagel or not
    // and there terurn the boolean value...

    void updateMove(int row, int col, Piece piece);
    // can update board By placing X or O...

    Winner checkWinner();
    //(tempary hear change retun value as boolean)
    //here we chan check is the players ara winn or not

    void printBoard();

    boolean isDraw();
}
