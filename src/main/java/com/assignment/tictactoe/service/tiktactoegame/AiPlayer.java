package com.assignment.tictactoe.service.tiktactoegame;

public class AiPlayer extends Player{
    private Piece piece;
    private int row;
    private int cal;

    public AiPlayer(Piece piece,BoardImpl board){
        super(board);
        this.piece = piece;
    }

    @Override
    public void move(int row, int cal) {
        //HERE ASSIGN THE VALUES CAME FROM bestValue (bestCal and bestRow)...
        this.row = row;
        this.cal = cal;

        board.updateMove(row,cal,piece);
        /*HERE UPDATE THE BOARD... Array
        * To update the UI use the Getters methods of the
        * Ai player... (getRow(), getCal())
        * */
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void findBestMove() {
        int bestValue = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        Piece[][] pieces = board.getPieces();

        //HERE RUN THE LOOP FOR All INDEXES ON THE Piece[][]
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {

                //CHECK IS THERE HAVA ANY EMPTY INDEXES-> (Finding the Valid move)
                if (pieces[i][j] == Piece.EMPTY) {
                    pieces[i][j] = Piece.O; // ADD THE AI PLAYERS MOVE

                    //isMaximizing == true: It’s the AI’s turn, and the AI tries to maximize the score.
                    //isMaximizing == false: It’s the opponent’s turn, and the opponent tries to
                    //minimize the AI’s score

                    //HERE Ai player plays humanPlayer turn
                    int moveValue = minimax(pieces, 0, false);
                    pieces[i][j] = Piece.EMPTY; // UNDO

                    //CHECK ISMoveValue GRATER THAN bestValue OR NOT..
                    if (moveValue > bestValue) {
                        // IS THAT VALUE IS GRATER THAN TO BEST VALUE
                        // THEN SAVE THE i, j as bestRow , bestCal
                        // AND moveValue As the NEW bestValue

                        bestRow = i;
                        bestCol = j;
                        bestValue = moveValue;
                    }
                }
            }
        }


        if (bestRow != -1 && bestCol != -1) {
            move(bestRow, bestCol);
        }
    }


    private int minimax(Piece[][] pieces, int depth, boolean isMaximizing) {
        Winner winner = board.checkWinner();

        //CHECK IS THERE HAVEN'T ANY WINNER...
        if (winner != null) {

            if (winner.getWinnerPiese() == Piece.O) {
                //IS AiPlayer Win
                return 10 - depth; // +10
            } else if (winner.getWinnerPiese() == Piece.X) {
                //IS HumanPlayer WIN
                return depth - 10; // -10
            }
        }

        if (board.isDraw()) {
            return 0;
        }

        if (isMaximizing) {
            //THIS IS AI turn
            //AI tries to maximize the score.
            int bestValue = Integer.MIN_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.O;
                        bestValue = Math.max(bestValue, minimax(pieces, depth + 1, false));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        } else {
            //THIS IS HumanPlayerTurn Plays by AI Player
            //The opponent tries to minimize the AI’s score
            int bestValue = Integer.MAX_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.X;
                        bestValue = Math.min(bestValue, minimax(pieces, depth + 1, true));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        }
    }
}
