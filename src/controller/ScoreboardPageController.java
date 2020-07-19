package controller;

import commons.queries.ScoreboardRequest;
import commons.queries.ScoreboardResult;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.interactWithServer.Client;

public class ScoreboardPageController {
    @FXML
    ListView<String> scoreboard;
    ObservableList<String> observableList= FXCollections.observableArrayList();

    public void initialize() {
        Client.curPageController= this;
        Client.socketOutput.send(new ScoreboardRequest(Client.curUser.username));
    }

    public void updateScoreboard(ScoreboardResult scoreboardResult) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                observableList.setAll(scoreboardResult.scoreboard);
                scoreboard.setItems(observableList);
            }
        });
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MenuPage.fxml");
    }
}
