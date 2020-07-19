package controller;

import commons.dataTypes.SearchDetails;
import commons.queries.GameRequest;
import commons.queries.SearchRequest;
import commons.queries.SearchResult;
import commons.queries.UpdateBlockList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.interactWithServer.Client;

import java.util.ArrayList;
import java.util.LinkedList;


public class MatchMakingPageController extends DefaultController{

    @FXML
    TextField searchBar;
    @FXML
    ListView<String> result;
    ObservableList<String> resultObservableList= FXCollections.observableArrayList();
    LinkedList<SearchDetails> searchDetails;

    public void initialize() {
        Client.curPageController= this;
        Client.socketOutput.send(new SearchRequest(Client.curUser.username,""));
    }

    public void updateResult(SearchResult searchResult){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                searchDetails= searchResult.searchResult;
                resultObservableList.clear();
                for(SearchDetails u: searchDetails)
                    resultObservableList.add(u.toString());
                result.setItems(resultObservableList);
            }
        });
    }

    /*public void requestAccepted(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }*/

    public void receiveRequest(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public void sendGameRequestPressed(ActionEvent actionEvent) {
        String s=result.getSelectionModel().getSelectedItem();
        int ind=resultObservableList.indexOf(s);

        Client.socketOutput.send(new GameRequest(Client.curUser.username, searchDetails.get(ind).username));
    }

    public void blockPressed(ActionEvent actionEvent) {
        //result.getOnMousePressed().handle();
        String s=result.getSelectionModel().getSelectedItem();
        //searchDetails.indexOf();
        int ind=resultObservableList.indexOf(s);
        resultObservableList.remove(ind);
        Client.socketOutput.send(new UpdateBlockList(Client.curUser.username, searchDetails.get(ind).username, true));

        // necessary??
        //Client.curUser.updateBlockList(searchDetails.get(ind).username,true);
        searchDetails.remove(ind);

        result.setItems(resultObservableList);
    }

    public void searchPressed(ActionEvent actionEvent) {
        Client.socketOutput.send(new SearchRequest(Client.curUser.username,searchBar.getText()));
    }

    public void backPressed(ActionEvent actionEvent) throws Exception {
        new PageLoader().load("../view/MenuPage.fxml");
    }
}
