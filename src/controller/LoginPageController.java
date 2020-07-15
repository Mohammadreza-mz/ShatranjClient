package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class LoginPageController {

    @FXML
    TextField user;
    @FXML
    TextField pass;

    @FXML
    Label wrongLabel;

    public void loginPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/LoginPage.fxml");
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/HomePage.fxml");
    }

    public void forgotPasswordPressed(ActionEvent actionEvent) {
    }
}
