package controller;

import javafx.event.ActionEvent;

public class InfoPageController {
    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/HomePage.fxml");
    }
}
