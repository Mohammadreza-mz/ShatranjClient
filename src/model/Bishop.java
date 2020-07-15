package model;

public class Bishop extends Piece {
    public Bishop(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if(Math.abs(this.x - x) == Math.abs(this.y-y))
            return true;
        return false;
    }
}
