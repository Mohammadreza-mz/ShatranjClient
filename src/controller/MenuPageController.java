package controller;

import javafx.event.ActionEvent;

public class MenuPageController {
    public void gameRequestPressed(ActionEvent actionEvent) {
    }

    public void historyPressed(ActionEvent actionEvent) {
    }

    public void scoreBoardPressed(ActionEvent actionEvent) {
    }

    public void profilePressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/ProfilePage.fxml");
    }

    public void watchOthersGamesPressed(ActionEvent actionEvent) {
    }

    public void logoutPressed(ActionEvent actionEvent) throws Exception {
        // just for test
        new PageLoader().load("../view/HomePage.fxml");
    }
}
