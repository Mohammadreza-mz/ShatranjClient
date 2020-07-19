package commons.queries;

import java.io.Serializable;

public class GameAccepted implements Serializable {
    public String from,to;

    public GameAccepted(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
