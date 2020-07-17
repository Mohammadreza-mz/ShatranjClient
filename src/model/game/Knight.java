package model.game;

import javafx.scene.image.Image;

public class Knight extends Piece {

    public Knight(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            image=new Image(getClass().getResource("/images/white/knight.png").toExternalForm());
        else
            image=new Image(getClass().getResource("/images/black/knight.png").toExternalForm());
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!super.canMoveTo(x,y))
            return false;
        if((Math.abs(x-this.x)==1 && Math.abs(y-this.y)==2) || (Math.abs(x-this.x)==2 && Math.abs(y-this.y)==1))
            return true;
        return false;
    }
}
