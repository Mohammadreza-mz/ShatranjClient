package model;

public class Queen extends Piece {
    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if(this.x == x || this.y == y)
            return true;
        if(Math.abs(this.x - x) == Math.abs(this.y-y))
            return true;
        return false;
    }
}
