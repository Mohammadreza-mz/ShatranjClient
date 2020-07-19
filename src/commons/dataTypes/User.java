package commons.dataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class User implements Serializable {
    public String username;
    private String password;
    LinkedList<GameRecord> history= new LinkedList<>();
    LinkedList<String> blockList= new LinkedList<>();
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

    public void updateBlockList(String username, boolean isAdding){
        if(isAdding)
            blockList.add(username);
        else
            blockList.remove(username);
    }

    public void addToHistory(GameRecord gameRecord){
        history.add(0, gameRecord);
    }

    public LinkedList<SearchDetails> lastOpponent(){
        LinkedList<SearchDetails> ret= new LinkedList<>();
        /*for(GameRecord u:history){
            if(ret.contains(new SearchDetails(u.)))
        }*/
        return ret;
    }

    public SearchDetails details(){
        return new SearchDetails(username,win,lose);
    }
}
