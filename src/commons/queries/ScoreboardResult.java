package commons.queries;

import java.io.Serializable;
import java.util.LinkedList;

public class ScoreboardResult implements Serializable {
    public LinkedList<String> scoreboard;

    public ScoreboardResult(LinkedList<String> scoreboard) {
        this.scoreboard = scoreboard;
    }
}
