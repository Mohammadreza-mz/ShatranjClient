package commons.game;

public class King extends Piece {

    public King(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            imagePath="/images/white/king.png";
        else
            imagePath="/images/black/king.png";
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
