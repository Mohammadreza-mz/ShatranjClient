package controller;

import javafx.event.ActionEvent;
import model.interactWithServer.Client;

public class InfoPageController extends DefaultController{

    public void initialize() {
        Client.curPageController= this;
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MenuPage.fxml");
    }
}
