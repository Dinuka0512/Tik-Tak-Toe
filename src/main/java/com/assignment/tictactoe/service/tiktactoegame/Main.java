package com.assignment.tictactoe.service.tiktactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent fxmlLorder = FXMLLoader.load(getClass().getResource("/view/frist.fxml"));
        Scene scene = new Scene(fxmlLorder);
        stage.setTitle("Tik Tac Toe");

        //here add the logo for our application
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
