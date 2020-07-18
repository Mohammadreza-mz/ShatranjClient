package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PageLoader {
    public static Stage stage;

    public static void initStage(Stage primaryStage){
        stage= primaryStage;
        primaryStage.setTitle("Online Chess");
        stage.setWidth(1000);
        stage.setHeight(700);
    }

    public void load(String url) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        stage.setScene(new Scene(root, 750, 750));
        stage.show();
    }
}
