package model.interactWithServer;

import commons.queries.SearchResult;
import controller.LoginPageController;
import controller.MatchMakingPageController;
import controller.ScoreboardPageController;
import controller.SignUpPageController;
import commons.queries.LoginResult;
import commons.queries.ScoreboardResult;
import commons.queries.SignUpResult;
import commons.dataTypes.User;
import commons.game.Board;
import commons.game.Player;

import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static Socket socket;
    public static User curUser;
    public static Player curGamePlayer;
    public static Board curBoard;
    public static SocketInput socketInput;
    public static SocketOutput socketOutput;
    public static Object curPageController;
    public static ArrayList<String> curChat;

    public static void setSocket(Socket newSocket){
        //socket closed at controller
        /*if(socket!=null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }*/
        socket=newSocket;
        socketInput= new SocketInput(socket);
        new Thread(socketInput).start();
        socketOutput= new SocketOutput(socket);
    }

    public static void receivedPieceMove(PieceMove pieceMove){

    }

    public static void receivedLoginResult(LoginResult loginResult) throws Exception {
        if(loginResult.user!= null)
            curUser= loginResult.user;
        if(curPageController instanceof LoginPageController)
            ((LoginPageController) curPageController).loginResult(loginResult);
    }

    public static void receivedSignUpResult(SignUpResult signUpResult) throws Exception {
        if(signUpResult.user!= null)
            curUser= signUpResult.user;
        if(curPageController instanceof SignUpPageController)
            ((SignUpPageController) curPageController).signUpResult(signUpResult);
    }

    public static void receivedSearchResult(SearchResult searchResult){
        if(curPageController instanceof MatchMakingPageController)
            ((MatchMakingPageController) curPageController).updateResult(searchResult);
    }

    public static void receivedScoreboard(ScoreboardResult scoreboardResult){
        if(curPageController instanceof ScoreboardPageController)
            ((ScoreboardPageController) curPageController).updateScoreboard(scoreboardResult);
    }
}
