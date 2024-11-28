package com.assignment.tictactoe.service.tiktactoegame;

public class HumanPlayer extends Player{
    private Piece piece;
    public HumanPlayer(Piece piece, BoardImpl board){
        super(board);
        this.piece = piece;
    }

    @Override
    public void move(int row, int cal) {
        board.updateMove(row,cal,piece);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
