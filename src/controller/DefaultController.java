package controller;

import commons.dataTypes.EndState;
import commons.queries.GameAccepted;
import commons.queries.GameEnd;
import commons.queries.GameFailed;
import commons.queries.GameRequest;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.interactWithServer.Client;

import java.util.Optional;

public class DefaultController{
    public void goTOGamePage(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PageLoader().load("../view/HomePage.fxml");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void gameEnd(GameEnd gameEnd){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String s;
                if(gameEnd.endState.equals(EndState.LEFTGAME))
                    s= "You won! Your opponent left the game!";
                else if(gameEnd.endState.equals(EndState.LOST))
                    s= "You won!";
                else
                    s= "You Lost!";
                Alert alert= new Alert(Alert.AlertType.INFORMATION,"Game over!"+s);
                alert.showAndWait();
            }
        });
    }

    public void gameRequest(GameRequest gameRequest){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText(gameRequest.from+" has sent you a game invitation");
                alert.setContentText("Do you wanna Accept it?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    Client.socketOutput.send(new GameAccepted(gameRequest.to,gameRequest.to));
                }
            }
        });
    }

    public void gameFailed(GameFailed gameFailed){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert= new Alert(Alert.AlertType.INFORMATION,"cannot join the game! Your invitation has expired!");
                alert.showAndWait();
            }
        });
    }
}
