package model.interactWithServer;

import java.io.Serializable;

public class GameMessages implements Serializable {
    public final String message;

    public GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
