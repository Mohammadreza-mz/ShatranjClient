package commons.game;

public class Queen extends Piece {

    public Queen(int x, int y, Color color, Board board) {
        super(x, y, color, board);
        if(color.equals(Color.WHITE))
            imagePath="/images/white/queen.png";
        else
            imagePath="/images/black/queen.png";
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        if(!fitInBoard(x,y) || (this.x==x && this.y==y))
            return false;
        if(this.x == x || this.y == y) {
            if(this.x == x ){
                int sign= (this.y < y? 1:-1);
                for(int i=1;i<Math.abs(this.y-y);i++){
                    if(board.occupiedByColor(this.x,this.y+sign*i)!=null)
                        return false;
                }
                return true;
            }
            else{
                int sign= (this.x < x? 1:-1);
                for(int i=1;i<Math.abs(this.x-x);i++){
                    if(board.occupiedByColor(this.x+sign*i,this.y)!=null)
                        return false;
                }
                return true;
            }
        }
        if(Math.abs(this.x - x) == Math.abs(this.y-y)) {
            int deltaXSign=(this.x<x ? 1:-1),deltaYSign=(this.y<y ? 1:-1);
            for(int i=1; i< Math.abs(this.x-x) ;i++){
                if(board.occupiedByColor(this.x+ deltaXSign*i  , this.y+ deltaYSign*i)!= null)
                    return false;
            }
            return true;
        }
        return false;
    }
}
