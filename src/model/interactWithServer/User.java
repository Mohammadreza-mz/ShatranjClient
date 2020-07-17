package model.interactWithServer;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public String username;
    private String password;
    ArrayList<GameRecord> history;
    ArrayList<String> blockList;
    int win,lose;
}
