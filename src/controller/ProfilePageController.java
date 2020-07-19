package controller;

import commons.queries.ChangePassword;
import commons.queries.DeleteAccount;
import commons.queries.ScoreboardRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.interactWithServer.Client;

public class ProfilePageController extends DefaultController{
    @FXML
    TextField pass;

    public void initialize() {
        Client.curPageController= this;
    }

    public void changePressed(ActionEvent actionEvent) {
        if(!pass.getText().matches("[A-Za-z0-9]*")){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain only english letters and numbers!");
            alert.showAndWait();
        }
        else if(pass.getText().length()<8){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password must contain at least 8 characters!");
            alert.showAndWait();
        }
        else{
            Client.curUser.setPassword(pass.getText());
            Client.socketOutput.send(new ChangePassword(Client.curUser.username,pass.getText()));
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Password changed!");
            alert.showAndWait();
        }
    }

    public void DeleteAccountPressed(ActionEvent actionEvent) throws Exception {
        Client.socketOutput.send(new DeleteAccount(Client.curUser.username));
        Client.curUser= null;
        Alert alert= new Alert(Alert.AlertType.INFORMATION,"Account Deleted!");
        alert.showAndWait();
        new PageLoader().load("../view/HomePage.fxml");
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MenuPage.fxml");
    }
}
