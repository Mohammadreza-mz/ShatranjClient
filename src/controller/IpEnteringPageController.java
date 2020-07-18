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
    int port=8080;

    public void connectPressed(ActionEvent actionEvent) {
        try {
            Socket socket= new Socket(ip.getText(),port);
            System.out.println(ip.getText());
            Client.setSocket(socket);
            new PageLoader().load("../view/HomePage.fxml");
        }
        catch (IOException e){
            Alert alert= new Alert(Alert.AlertType.INFORMATION,"Problems detected while trying to connect to this IP!");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
