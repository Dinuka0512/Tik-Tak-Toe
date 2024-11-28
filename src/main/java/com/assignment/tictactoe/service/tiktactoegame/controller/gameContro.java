package com.assignment.tictactoe.service.tiktactoegame.controller;

import com.assignment.tictactoe.service.tiktactoegame.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class gameContro implements Initializable {

    private BoardImpl board;
    private AiPlayer aiPlayer;
    private HumanPlayer humanPlayer;


    @FXML
    private Button btn10;

    @FXML
    private Button btn21;

    @FXML
    private Button btn20;

    @FXML
    private Button btn02;

    @FXML
    private Button btn01;

    @FXML
    private Button btn12;

    @FXML
    private Button btn00;

    @FXML
    private Button btn11;

    @FXML
    private Button btn22;

    @FXML
    private Button btnReset;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        board = new BoardImpl();

        humanPlayer = new HumanPlayer(Piece.X , board);
        aiPlayer = new AiPlayer(Piece.O, board);
    }


    @FXML
    void btn1(ActionEvent event) {
        onClick(0,0,btn00);
    }

    @FXML
    void btn2(ActionEvent event) {
        onClick(0,1,btn01);
    }

    @FXML
    void btn3(ActionEvent event) {
        onClick(0,2,btn02);
    }

    @FXML
    void btn4(ActionEvent event) {
        onClick(1,0,btn10);
    }

    @FXML
    void btn5(ActionEvent event) {
        onClick(1,1,btn11);
    }

    @FXML
    void btn6(ActionEvent event) {
        onClick(1,2,btn12);
    }

    @FXML
    void btn7(ActionEvent event) {
        onClick(2,0,btn20);
    }

    @FXML
    void btn8(ActionEvent event) {
        onClick(2,1,btn21);
    }

    @FXML
    void btn9(ActionEvent event) {
        onClick(2,2,btn22);
    }

    private void onClick(int row, int cal, Button btn){
        boolean isValidMove = board.isLegalMove(row,cal);
        if(isValidMove){
            btn.setText(humanPlayer.getPiece().name());
            humanPlayer.move(row, cal);
            aiPlayer.findBestMove();
            board.printBoard();
            updateAiMove(); //UPDATE UI ONLY

            Winner isWin = board.checkWinner();
            if(isWin != null){
                new Alert(Alert.AlertType.CONFIRMATION,isWin.getWinnerPiese()+ " is game Won").show();
                System.out.println(isWin.getWinnerPiese() + " is game won...");
                newBoard();
            }else{
                if(board.isDraw()){
                    new Alert(Alert.AlertType.CONFIRMATION,"The game is Drow").show();
                    System.out.println("The game is Drow...!");
                    newBoard();
                }
            }

        }else{
            System.out.println("INVALID MOVE..");
        }
    }

    private void updateAiMove(){
        int row = aiPlayer.getRow();
        int cal = aiPlayer.getCal();

        switch (row +""+cal){
            case "00" -> {
                btn00.setText(aiPlayer.getPiece().name());
            }
            case "01" -> {
                btn01.setText(aiPlayer.getPiece().name());
            }
            case "02" -> {
                btn02.setText(aiPlayer.getPiece().name());
            }
            case "10" -> {
                btn10.setText(aiPlayer.getPiece().name());
            }
            case "11" -> {
                btn11.setText(aiPlayer.getPiece().name());
            }
            case "12" -> {
                btn12.setText(aiPlayer.getPiece().name());
            }
            case "20" -> {
                btn20.setText(aiPlayer.getPiece().name());
            }
            case "21" -> {
                btn21.setText(aiPlayer.getPiece().name());
            }
            case "22" -> {
                btn22.setText(aiPlayer.getPiece().name());
            }
            default -> {
                System.out.println("Nothing");
                System.out.println(row + "" + cal);
            }
        }
    }


    @FXML
    void newBoard(ActionEvent event) {
        newBoard();
    }

    private void newBoard() {
        board.initializeBoard();
        clearText();
    }

    private void clearText(){
        btn00.setText("");
        btn01.setText("");
        btn02.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn20.setText("");
        btn21.setText("");
        btn22.setText("");
    }
}
