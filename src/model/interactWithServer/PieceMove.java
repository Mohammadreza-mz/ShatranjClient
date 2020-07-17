package model.interactWithServer;

import java.io.Serializable;

public class PieceMove implements Serializable {
    public final int fromX,fromY,toX,toy;

    public PieceMove(int fromX, int fromY, int toX, int toy) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toy = toy;
    }
}
