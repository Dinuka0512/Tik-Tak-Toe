package com.assignment.tictactoe.service.tiktactoegame;

public class BoardImpl implements Board{
    private Piece[][] pieces = new Piece[3][3];

    public BoardImpl(){
        initializeBoard();
        printBoard();
    }

    @Override
    public void initializeBoard() {
        //There reset the board to -> empty
        for(int i = 0; i < pieces.length; i++){
            for(int j = 0; j < pieces[i].length; j++){
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public boolean isLegalMove(int row, int cal) {
        return pieces[row][cal] == Piece.EMPTY;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    @Override
    public Winner checkWinner() {
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i][0] == pieces[i][1] && pieces[i][1] == pieces[i][2] && pieces[i][0] != Piece.EMPTY){
                return new Winner(pieces[i][0]);
            }
        }

        for(int i = 0; i < pieces.length; i++){
            if(pieces[0][i] == pieces[1][i] && pieces[1][i] == pieces[2][i] && pieces[0][i] != Piece.EMPTY){
                return new Winner(pieces[0][i]);
            }
        }

        if(pieces[0][0] == pieces[1][1] && pieces[1][1] == pieces[2][2] && pieces[0][0] != Piece.EMPTY){
            return new Winner(pieces[0][0]);
        }

        if(pieces[0][2] == pieces[1][1] && pieces[1][1] == pieces[2][0] && pieces[0][2] != Piece.EMPTY){
            return new Winner(pieces[0][2]);
        }
        return null;
    }

    @Override
    public void printBoard() {
        /*In this methord I have created the print board methord..
        By useing this we can print the board on our terminal..
        */
        System.out.println("=============");
        for (int i = 0; i < pieces.length; i++){
            System.out.print("| ");
            for(int j = 0; j < pieces[i].length; j++){
                if(pieces[i][j] == Piece.EMPTY){
                    System.out.print("  | ");
                }else{
                    System.out.print(pieces[i][j] + " | ");
                }
            }
            System.out.println("\n=============");
        }
    }

    @Override
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false; // Still empty spaces available
                }
            }
        }
        return true; // Board is full
    }

    public Piece[][] getPieces() {
        return pieces;
    }
}
