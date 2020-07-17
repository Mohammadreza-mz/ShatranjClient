package model.game;

import javafx.scene.image.Image;

public class Pawn extends Piece {

    public Pawn(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            image=new Image(getClass().getResource("/images/white/pawn.png").toExternalForm());
        else
            image=new Image(getClass().getResource("/images/black/pawn.png").toExternalForm());
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!super.canMoveTo(x,y))
            return false;
        if(Math.abs(this.x-x)>1)
            return false;
        if(color.equals(Color.WHITE)) {
            if (y != this.y + 1)
                return false;
        }
        else {
            if (y != this.y - 1)
                return false;
        }

        if(this.x==x){
            if(board.occupiedByColor(x,y)!=null)
                return false;
            return true;
        }
        else{
            if(board.occupiedByColor(x,y)!=null && !board.occupiedByColor(x,y).equals(color))
                return true;
            return false;
        }
    }
}
