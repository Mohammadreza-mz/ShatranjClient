package commons.queries;

import java.io.Serializable;

public class GameFailed implements Serializable {
    public String from,to;

    public GameFailed(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
