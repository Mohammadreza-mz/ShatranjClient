package commons.game;

import java.io.Serializable;

public class Game implements Serializable {
    public String to;
    public Board board;
    public Color color;
    public long timeStamp;
    public int totalMoves;

    public Game(String to, Board board, Color color, long timeStamp, int totalMoves) {
        this.to = to;
        this.board = board;
        this.color = color;
        this.timeStamp = timeStamp;
        this.totalMoves = totalMoves;
    }
}
