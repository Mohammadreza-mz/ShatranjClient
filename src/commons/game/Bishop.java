package commons.game;

public class Bishop extends Piece {

    public Bishop(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            imagePath="/images/white/bishop.png";
        else
            imagePath="/images/black/bishop.png";
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!super.canMoveTo(x,y))
            return false;
        if(Math.abs(this.x - x) != Math.abs(this.y-y))
            return false;
        int deltaXSign=(this.x<x ? 1:-1),deltaYSign=(this.y<y ? 1:-1);
        for(int i=1; i< Math.abs(this.x-x) ;i++){
            if(board.occupiedByColor(this.x+ deltaXSign*i  , this.y+ deltaYSign*i)!= null)
                return false;
        }
        return true;
    }
}
