package commons.dataTypes;

import java.io.Serializable;

public class SearchDetails implements Serializable {
    public String username;
    public int win,lose;

    public SearchDetails(String username, int win, int lose) {
        this.username = username;
        this.win = win;
        this.lose = lose;
    }

    @Override
    public String toString() {
        String ret= "     win:     ";
        for(int i=0;i<5-String.valueOf(win).length();i++)
            ret+=" ";
        ret+= win+"     lose:     ";
        for(int i=0;i<5-String.valueOf(lose).length();i++)
            ret+=" ";
        ret+= lose+"     "+username;
        return ret;
    }
}
