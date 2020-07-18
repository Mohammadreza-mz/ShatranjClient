package commons.dataTypes;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    public String username;
    private String password;
    ArrayList<GameRecord> history= new ArrayList<>();
    ArrayList<String> blockList= new ArrayList<>();
    int win=0,lose=0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkPassword(String password){
        return password.equals(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
