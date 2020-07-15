package model;

public class King extends Piece {

    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if(Math.abs(x-this.x) + Math.abs(y-this.y) ==1)
            return true;
        return false;
    }
}
