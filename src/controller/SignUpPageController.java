package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import commons.dataTypes.User;
import model.interactWithServer.Client;
import commons.queries.SignUpRequest;
import commons.queries.SignUpResult;

public class SignUpPageController {
    @FXML
    TextField user;
    @FXML
    TextField pass;

    public void initialize() {
        Client.curPageController= this;
    }

    public void createPressed(ActionEvent actionEvent) {
        if(!user.getText().matches("[A-Za-z0-9]*")){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Username must contain only english letters and numbers!");
            alert.showAndWait();
        }
        else if(!pass.getText().matches("[A-Za-z0-9]*")){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain only english letters and numbers!");
            alert.showAndWait();
        }
        else if(pass.getText().length()<8){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain at least 8 characters!");
            alert.showAndWait();
        }
        else if(user.getText().equals("")){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Username field cannot be empty!");
            alert.showAndWait();
        }
        else{
            Client.socketOutput.send(new SignUpRequest(new User(user.getText(),pass.getText())));
        }

    }

    public void signUpResult(SignUpResult signUpResult) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(signUpResult.user == null){
                    Alert alert= new Alert(Alert.AlertType.INFORMATION,"The username is taken! Please try another username!");
                    alert.showAndWait();
                }
                else{
                    Alert alert= new Alert(Alert.AlertType.INFORMATION,"Welcome!");
                    alert.showAndWait();
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
}
