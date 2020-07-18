package commons.game;

import java.io.Serializable;

public class Player implements Serializable {
    public final Color color;
    public final String username;

    public Player(Color color, String username) {
        this.color = color;
        this.username = username;
    }
}
