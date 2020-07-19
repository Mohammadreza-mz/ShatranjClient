package commons.queries;

import java.io.Serializable;

public class ScoreboardRequest implements Serializable {
    public String username;

    public ScoreboardRequest(String username) {
        this.username = username;
    }
}
