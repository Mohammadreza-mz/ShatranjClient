package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SignUpPageController {
    @FXML
    TextField user;
    @FXML
    TextField pass;

    public void createPressed(ActionEvent actionEvent) {
        if(!pass.getText().matches("[A-Za-z0-9]+")){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain only english letters and numbers!");
            alert.showAndWait();
        }
        if(pass.getText().length()<8){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain at least 8 characters!");
            alert.showAndWait();
        }

    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/HomePage.fxml");
    }
}
