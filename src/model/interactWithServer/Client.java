package model.interactWithServer;

import controller.GamePageController;
import model.game.Board;

import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static Socket socket;
    public static User curUser;
    public static Board curBoard;
    public static SocketInput socketInput;
    public static SocketOutput socketOutput;
    public static GamePageController gamePageController;
    public static ArrayList<String> curChat;

    public static void setSocket(Socket socket){
        //TODO
    }

    public static void receivedPieceMove(PieceMove pieceMove){

    }



}
