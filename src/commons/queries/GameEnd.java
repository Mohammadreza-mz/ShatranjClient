package commons.queries;

import commons.dataTypes.EndState;
import commons.game.Board;

import java.io.Serializable;



public class GameEnd implements Serializable {
    public String from,to;
    public Board board;
    public long timeStamp;
    public int totalMoves;
    public EndState endState;

    public GameEnd(String from, String to, Board board, long timeStamp, int totalMoves, EndState endState) {
        this.from = from;
        this.to = to;
        this.board = board;
        this.timeStamp = timeStamp;
        this.totalMoves = totalMoves;
        this.endState = endState;
    }
}
