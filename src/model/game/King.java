package model.game;

import javafx.scene.image.Image;

public class King extends Piece {

    public King(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            image=new Image(getClass().getResource("/images/white/king.png").toExternalForm());
        else
            image=new Image(getClass().getResource("/images/black/king.png").toExternalForm());
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!super.canMoveTo(x,y))
            return false;
        if(Math.abs(x-this.x) + Math.abs(y-this.y) !=1)
            return false;
        return true;
    }
}
