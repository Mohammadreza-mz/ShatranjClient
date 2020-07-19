package model.interactWithServer;

import commons.queries.*;

import java.io.*;
import java.net.Socket;

public class SocketInput implements Runnable{

    Socket socket;

    public SocketInput(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis=null;
        ObjectInputStream ois=null;
        try {
            dis= new DataInputStream(socket.getInputStream());
            ois= new ObjectInputStream(dis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                Object object= ois.readObject();
                if(object instanceof LoginResult){
                    Client.receivedLoginResult((LoginResult) object);
                }
                if(object instanceof SignUpResult){
                    Client.receivedSignUpResult((SignUpResult) object);
                }
                if (object instanceof SearchResult){
                    Client.receivedSearchResult((SearchResult) object);
                }
                if (object instanceof ScoreboardResult){
                    Client.receivedScoreboard((ScoreboardResult) object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
