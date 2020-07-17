package model.game;



public abstract class Piece {
    public int x,y;
    public Color color;
    public Board board;
    public boolean playing=true;

    public Piece(int x, int y, Color color, Board board) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
    }

    public static boolean fitInBoard(int x, int y){
        if(x<1 || x>8 || y<1 || y>8)
            return false;
        return true;
    }

    public void setNotPlaying() {
        this.playing = false;
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean canMoveTo(int x, int y){
        if(!fitInBoard(x,y) || (this.x==x && this.y==y) || color.equals(board.occupiedByColor(x,y)))
            return false;
        return true;
    }

    public boolean moveTo(int x,int y){
        if(!canMoveTo(x,y))
            return false;
        this.x=x;
        this.y=y;
        return true;
    }
}
