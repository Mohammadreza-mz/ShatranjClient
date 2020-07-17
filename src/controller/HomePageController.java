package controller;

import javafx.event.ActionEvent;
import model.interactWithServer.Client;

public class HomePageController {
    public void signUpPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/SignUpPage.fxml");
    }

    public void loginPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/LoginPage.fxml");
    }

    public void infoPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/InfoPage.fxml");
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        Client.socket.close();
        new PageLoader().load("../view/IpEnteringPage.fxml");
    }
}
