package com.assignment.tictactoe.service.tiktactoegame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class fristContro {

    @FXML
    private Button btnPlayNow;

    @FXML
    private AnchorPane body;

    @FXML
    void startGame(ActionEvent event) {
        try{
            body.getChildren().clear();
            AnchorPane loard = FXMLLoader.load(getClass().getResource("/view/game.fxml"));
            body.getChildren().add(loard);
        }catch(IOException e1){
            System.out.println("IOException");
            e1.printStackTrace();
        }
    }
}
