package model;

public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if(this.x == x || this.y == y)
            return true;
        return false;
    }

}
