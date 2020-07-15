package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProfilePageController {
    @FXML
    TextField pass;

    public void changePressed(ActionEvent actionEvent) {
    }

    public void DeleteAccountPressed(ActionEvent actionEvent) {
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MenuPage.fxml");
    }
}
