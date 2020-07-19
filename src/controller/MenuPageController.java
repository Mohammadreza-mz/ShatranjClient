package controller;

import javafx.event.ActionEvent;
import model.interactWithServer.Client;
import commons.queries.Logout;

public class MenuPageController extends DefaultController{

    public void initialize() {
        Client.curPageController= this;
    }

    public void gameRequestPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MatchMakingPage.fxml");
    }

    public void historyPressed(ActionEvent actionEvent) {
    }

    public void scoreBoardPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/ScoreboardPage.fxml");
    }

    public void profilePressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/ProfilePage.fxml");
    }

    public void watchOthersGamesPressed(ActionEvent actionEvent) {
    }

    public void logoutPressed(ActionEvent actionEvent) throws Exception {
        Client.socketOutput.send(new Logout(Client.curUser.username));
        new PageLoader().load("../view/HomePage.fxml");
    }

    public void infoPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/InfoPage.fxml");
    }
}
