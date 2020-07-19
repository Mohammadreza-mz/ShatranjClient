package model.interactWithServer;

import commons.game.Color;
import commons.game.Game;
import commons.queries.*;
import controller.*;
import commons.dataTypes.User;
import commons.game.Board;
import commons.game.Player;

import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static Socket socket;
    public static User curUser;
    //public static Player curGamePlayer;
    //public static Color curGameColor;
    //public static Board curBoard;
    public static Game curGame;
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

    public static void receivedGameRequest(GameRequest gameRequest){
        if(curPageController instanceof DefaultController)
            ((DefaultController) curPageController).gameRequest(gameRequest);
    }

    public static void receivedGameAccepted(GameAccepted gameAccepted){
        if(curGame == null){
            if(curPageController instanceof DefaultController) {
                long timeStamp=System.currentTimeMillis() / 1000;
                curGame= new Game(gameAccepted.from,new Board(),Color.BLACK,timeStamp,0);
                socketOutput.send(new GameUpdate(curUser.username,gameAccepted.from,new Board(),timeStamp,0));
                ((DefaultController) curPageController).goTOGamePage();
            }
        }
        else{
            socketOutput.send(new GameFailed(curUser.username,gameAccepted.from));
        }
    }

    public static void receivedGameFailed(GameFailed gameFailed){
        if(curPageController instanceof DefaultController)
            ((DefaultController) curPageController).gameFailed(gameFailed);
    }

    public static void receivedGameUpdate(GameUpdate gameUpdate){
        if(curGame== null){
            curGame= new Game(gameUpdate.from,gameUpdate.board,Color.WHITE,gameUpdate.timeStamp,0);
            if(curPageController instanceof DefaultController)
                ((DefaultController) curPageController).goTOGamePage();
        }
        else {
            curGame.board = gameUpdate.board;
        }
        //curGame.totalMoves++;?????
        //change turn
    }

    public static void receivedGameEnd(GameEnd gameEnd){
        if(curPageController instanceof DefaultController)
            ((DefaultController) curPageController).gameEnd(gameEnd);
        curGame=null;
    }
}
