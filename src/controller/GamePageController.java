package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;

public class GamePageController {
    @FXML
    ImageView rookBL,rookBR;
    @FXML
    ImageView knightBL,knightBR;
    @FXML
    ImageView bishopBL,bishopBR;
    @FXML
    ImageView kingB;
    @FXML
    ImageView queenB;

    @FXML
    ImageView pawnB1,pawnB2,pawnB3,pawnB4,pawnB5,pawnB6,pawnB7,pawnB8;


    @FXML
    ImageView rookWL,rookWR;
    @FXML
    ImageView knightWL,knightWR;
    @FXML
    ImageView bishopWL,bishopWR;
    @FXML
    ImageView kingW;
    @FXML
    ImageView queenW;

    @FXML
    ImageView pawnW1,pawnW2,pawnW3,pawnW4,pawnW5,pawnW6,pawnW7,pawnW8;

    @FXML
    ChoiceBox<String> from,to;


    public void helpPressed(ActionEvent actionEvent) {
        Alert alert= new Alert(Alert.AlertType.INFORMATION,"برای حرکت دادن مهره ها، مهره مورد نظر خود و هدف را از پایین صفحه انتخاب کنید و Move را بزنید");
        alert.showAndWait();
    }

    public void movePressed(ActionEvent actionEvent) {

    }
}
