package model;



public abstract class Piece {
    public int x,y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean fitInBoard(int x,int y){
        if(x<1 || x>8 || y<1 || y>8)
            return false;
        return true;
    }

    public abstract boolean canMoveTo(int x,int y);

    public boolean moveTo(int x,int y){
        if(!canMoveTo(x,y))
            return false;
        this.x=x;
        this.y=y;
        return true;
    }
}
