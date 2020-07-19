package commons.queries;

import java.io.Serializable;

public class GameRequest implements Serializable {
    public String from,to;

    public GameRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
