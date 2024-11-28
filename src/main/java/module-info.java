module com.assignment.tictactoe.service.tiktactoegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment.tictactoe.service.tiktactoegame.controller to javafx.fxml;
    exports com.assignment.tictactoe.service.tiktactoegame;
}