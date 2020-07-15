package controller;

import javafx.event.ActionEvent;

public class HomePageController {
    public void signUpPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/SignUpPage.fxml");
    }

    public void loginPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/LoginPage.fxml");
    }

    public void infoPressed(ActionEvent actionEvent) {
    }
}
