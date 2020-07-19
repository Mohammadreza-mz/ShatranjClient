package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import commons.game.Board;
import commons.game.Player;
import commons.queries.GameMessages;

public class GamePageController extends DefaultController{
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
    TextField messageField;

    @FXML
    ChoiceBox<String> from,to;

    @FXML
    ListView<String> messageList;

    ObservableList<String> messagesObservableList= FXCollections.observableArrayList();
    ObservableList<String> fromObservableList= FXCollections.observableArrayList();
    ObservableList<String> toObservableList= FXCollections.observableArrayList();

    Board board=new Board();
    Player player;

    ImageView[] imageViews= {rookBL,rookBR, knightBL,knightBR, bishopBL,bishopBR, kingB, queenB,pawnB1,pawnB2,pawnB3,pawnB4,pawnB5,pawnB6,pawnB7,pawnB8,
            rookWL,rookWR, knightWL,knightWR, bishopWL,bishopWR, kingW, queenW, pawnW1,pawnW2,pawnW3,pawnW4,pawnW5,pawnW6,pawnW7,pawnW8};

    public void initialize(){
        /*messagesObservableList.addAll(Client.curChat);
        this.board= Client.curBoard;
        this.player= Client.curGamePlayer;*/

        ImageView[] tmp= {rookBL,rookBR, knightBL,knightBR, bishopBL,bishopBR, kingB, queenB,pawnB1,pawnB2,pawnB3,pawnB4,pawnB5,pawnB6,pawnB7,pawnB8,
                rookWL,rookWR, knightWL,knightWR, bishopWL,bishopWR, kingW, queenW, pawnW1,pawnW2,pawnW3,pawnW4,pawnW5,pawnW6,pawnW7,pawnW8};
        imageViews= tmp;
        //setBoardImages();

        /*ImageView tmp= pawnB1;
        pawnB1.setY(500);
        tmp.setY(22);*/

        /*

            page loading


         */
    }

    public void helpPressed(ActionEvent actionEvent) {
        Alert alert= new Alert(Alert.AlertType.INFORMATION,"برای حرکت دادن مهره ها، مهره مورد نظر خود و هدفش را از پایین صفحه انتخاب کنید و Move را بزنید");
        alert.showAndWait();
    }

    public void movePressed(ActionEvent actionEvent) {
        //pawnB1.setImage(new Image("../images/white/king.png"));
        //pawnB1.setImage(new Image("file:images/white/king.png"));
        //pawnB1.setImage(new Image(new File("images/white/king.png").toURI().toString()));
        //pawnB1.setImage(new Image(new File("images/white/king.png").toURI().toString()));


        /*ImageView cc=new ImageView(new Image(getClass().getResource("/images/white/king.png").toExternalForm()));
        cc.setX(400);
        cc.setY(400);
        cc.setFitHeight(79);
        cc.setFitWidth(89);
        cc.
        cc.setVisible(true);*/
        //pawnB1.setImage(new Image(getClass().getResource("/images/white/king.png").toExternalForm()));
        //pawnB1.setY(pawnB1.getY()+100);
        //pawnB1.setV


        //clear from , to


        setBoardImages();

    }
    public void leaveGamePressed(ActionEvent actionEvent) {
    }

    public void backToMenuPressed(ActionEvent actionEvent) {
    }

    public static int toXPageCoordination(int x){
        //return 15+61*x;
        return 12+68*x;
    }

    public static int toYPageCoordination(int y){
        //return 15+61*y;
        //return 70*y;
        return 67*y;
    }

    public void setBoardImages(){
        for(ImageView u:imageViews)
            u.setVisible(false);
        int cnt=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board.cells[i][j]!=null){
                    imageViews[cnt].setImage(new Image(getClass().getResource(board.cells[i][j].imagePath).toExternalForm()));
                    imageViews[cnt].setLayoutX(toXPageCoordination(i));
                    imageViews[cnt].setLayoutY(toYPageCoordination(j));
                    imageViews[cnt++].setVisible(true);
                }
            }
        }
    }

    public void quickReactionPressed(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();
        messagesObservableList.add(player.username+": "+value);
        messageList.setItems(messagesObservableList);
    }

    public synchronized void sendPressed(ActionEvent actionEvent) {
        String message= messageField.getText();
        messagesObservableList.add(player.username+": "+message);
        messageList.setItems(messagesObservableList);
        messageField.setText("");
    }

    public synchronized void receivedMessage(GameMessages gameMessages){
        String message= gameMessages.getMessage();
        messagesObservableList.add(message);
        messageList.setItems(messagesObservableList);
    }

    /*public void setBoard(Board board){
        //kingB.
        //for(int i=0;i<)
    }*/

    public void updateFrom(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board.cells[i][j]!= null && board.cells[i][j].color.equals(player.color)){
                    fromObservableList.add(((char)('A'+i))+""+((char)('8'-j)));
                }
            }
        }
        from.setItems(fromObservableList);
    }

    public void updateTo(){
        if(from.getValue()!= null){
            fromObservableList.clear();
            int x=from.getValue().charAt(0)-'A';
            int y=8-to.getValue().charAt(1);
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(board.canMove(x,y,i,j)){
                        fromObservableList.add(((char)('A'+i))+""+((char)('8'-j)));
                    }
                }
            }
            to.setItems(toObservableList);
        }
    }
}
