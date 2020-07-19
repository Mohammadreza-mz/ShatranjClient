package commons.queries;

import commons.game.Board;

import java.io.Serializable;

public class GameUpdate implements Serializable {
    public String from,to;
    public Board board;
    public long timeStamp;
    public int totalMoves;

    public GameUpdate(String from, String to, Board board, long timeStamp, int totalMoves) {
        this.from = from;
        this.to = to;
        this.board = board;
        this.timeStamp = timeStamp;
        this.totalMoves = totalMoves;
    }
}
