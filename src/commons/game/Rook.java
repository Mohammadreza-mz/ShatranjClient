package commons.game;

public class Rook extends Piece {

    public Rook(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            imagePath="/images/white/rook.png";
        else
            imagePath="/images/black/rook.png";
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!super.canMoveTo(x,y))
            return false;
        if(this.x == x ){
            int sign= (this.y < y? 1:-1);
            for(int i=1;i<Math.abs(this.y-y);i++){
                if(board.occupiedByColor(this.x,this.y+sign*i)!=null)
                    return false;
            }
            return true;
        }
        if(this.y==y){
            int sign= (this.x < x? 1:-1);
            for(int i=1;i<Math.abs(this.x-x);i++){
                if(board.occupiedByColor(this.x+sign*i,this.y)!=null)
                    return false;
            }
            return true;
        }
        return false;
    }

}
