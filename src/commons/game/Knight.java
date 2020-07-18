package commons.game;

public class Knight extends Piece {

    public Knight(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            imagePath="/images/white/knight.png";
        else
            imagePath="/images/black/knight.png";
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
