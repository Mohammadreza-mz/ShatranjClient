package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.interactWithServer.Client;
import commons.queries.LoginRequest;
import commons.queries.LoginResult;


public class LoginPageController {

    @FXML
    TextField user;
    @FXML
    TextField pass;

    @FXML
    Label wrongLabel;

    public void initialize() {
        Client.curPageController= this;
    }

    public void loginPressed(ActionEvent actionEvent) throws Exception {
        Client.socketOutput.send(new LoginRequest(user.getText(),pass.getText()));
    }

    public void loginResult(LoginResult loginResult) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert= new Alert(Alert.AlertType.INFORMATION,loginResult.message);
                alert.showAndWait();

                if(loginResult.user!= null){
                    try {
                        new PageLoader().load("../view/MenuPage.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/HomePage.fxml");
    }

    public void forgotPasswordPressed(ActionEvent actionEvent) {
    }
}
