package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUpPageController {
    @FXML
    TextField user;
    @FXML
    TextField pass;

    public void createPressed(ActionEvent actionEvent) {
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/HomePage.fxml");
    }
}
