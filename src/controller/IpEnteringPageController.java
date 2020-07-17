package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.interactWithServer.Client;

import java.io.IOException;
import java.net.Socket;

public class IpEnteringPageController {
    @FXML
    TextField ip;
    @FXML
    TextField port;

    public void connectPressed(ActionEvent actionEvent) {
        try {
            Client.socket= new Socket(ip.getText(),Integer.parseInt(ip.getText()));
        }
        catch (NumberFormatException e){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"the entered Port is wrong!");
            alert.showAndWait();
        }
        catch (IOException e){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Problems detected while trying to connect to this IP!");
            alert.showAndWait();
        }

    }
}
