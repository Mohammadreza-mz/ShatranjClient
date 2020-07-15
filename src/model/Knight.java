package model;

public class Knight extends Piece {
    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if((Math.abs(x-this.x)==1 && Math.abs(y-this.y)==2) || (Math.abs(x-this.x)==2 && Math.abs(y-this.y)==1))
            return true;
        return false;
    }
}
